package io.kascoder.vkclient;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kascoder.vkclient.domain.Language;
import io.kascoder.vkclient.oauth.OAuth;
import io.kascoder.vkclient.oauth.OAuthError;
import io.kascoder.vkclient.oauth.OAuthResponse;
import io.kascoder.vkclient.util.DefaultApiParams;
import io.kascoder.vkclient.util.HttpUtils;
import io.kascoder.vkclient.util.ParameterBuilder;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VkApiClient {

    private static final HttpClient DEFAULT_HTTP_CLIENT = HttpClient.newHttpClient();
    private static final String ACCESS_TOKEN_PARAM_NAME = "access_token";
    private static final String API_VERSION_PARAM_NAME = "v";
    private static final String LANGUAGE_PARAM_NAME = "lang";

    @Getter
    @NonNull
    private final String accessToken;
    @Getter
    @NonNull
    private final Integer userId;
    @NonNull
    @Builder.Default private final HttpClient httpClient = DEFAULT_HTTP_CLIENT;
    @Setter
    private Language language;

    public <T> T executeRequest(@NonNull VkApiRequest<T> vkApiRequest) {
        return executeRequest(vkApiRequest, language);
    }

    public <T> CompletableFuture<T> executeRequestAsync(@NonNull VkApiRequest<T> vkApiRequest) {
        return executeRequestAsync(vkApiRequest, language);
    }

    public <T> T executeRequest(@NonNull VkApiRequest<T> vkApiRequest, Language language) {
        try {
            return executeRequestAsync(vkApiRequest, language).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.debug("Error during executing request", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public <T> CompletableFuture<T> executeRequestAsync(@NonNull VkApiRequest<T> vkApiRequest, Language language) {
        var method = vkApiRequest.getHttpMethod();
        var vkAPiMethod = vkApiRequest.getMethod();
        var vkApiQuery = vkApiRequest.getVkApiQuery();

        var params = new HashMap<>(ParameterBuilder.buildParamMap(vkApiQuery));
        params.put(ACCESS_TOKEN_PARAM_NAME, accessToken);
        params.put(API_VERSION_PARAM_NAME, DefaultApiParams.API_VERSION);
        if (language != null) {
            params.put(LANGUAGE_PARAM_NAME, language.getCode());
        }

        var httpRequest = HttpRequest.newBuilder(URI.create(DefaultApiParams.API_URL + vkAPiMethod.path()))
                .method(method.toString(), HttpUtils.ofFormData(params))
                .build();

        LOGGER.debug("Request: {}", httpRequest.toString());
        LOGGER.debug("Params: {}", params);

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseMethodResponse(body, vkApiRequest.getClazz()));
    }

    public static VkApiClient byOAuth(OAuth authData) {
        return byOAuth(DEFAULT_HTTP_CLIENT, authData, null);
    }

    public static VkApiClient byOAuth(OAuth authData, Language language) {
        return byOAuth(DEFAULT_HTTP_CLIENT, authData, language);
    }

    public static VkApiClient byOAuth(HttpClient httpClient, @NonNull OAuth authData) {
        return byOAuth(httpClient, authData, null);
    }

    public static VkApiClient byOAuth(@NonNull HttpClient httpClient, @NonNull OAuth authData, Language language) {
        var params = ParameterBuilder.buildParamMap(authData);
        if (language != null) {
            params.put(LANGUAGE_PARAM_NAME, language.getCode());
        }

        var httpRequest = HttpRequest.newBuilder(URI.create(DefaultApiParams.OAUTH_URL))
                .POST(HttpUtils.ofFormData(params))
                .build();

        HttpResponse<String> httpResponse;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            LOGGER.error("Error during auth request sending: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        var response = parseOAuthResponse(httpResponse.body());

        return VkApiClient.builder()
                .accessToken(response.getAccessToken())
                .userId(response.getUserId())
                .httpClient(httpClient)
                .language(language)
                .build();
    }

    private static OAuthResponse parseOAuthResponse(String response) {
        try {
            var mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response);
            var hasError = jsonNode.get("error") != null;
            if (hasError) {
                throw mapper.readValue(response, OAuthError.class);
            }

            var authResponse = mapper.readValue(response, OAuthResponse.class);
            LOGGER.debug("Auth response: {}", authResponse);

            return authResponse;
        } catch (OAuthError e) {
            LOGGER.error("OAuth Error: {}", e.toString());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Invalid auth response JSON: {}", response);
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    private <T> T parseMethodResponse(String responseJson, Class<T> clazz) {
        Response<T> apiResponse;
        try {
            var mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Response.class, clazz);
            apiResponse = mapper.readValue(responseJson, type);
        } catch (Exception e) {
            LOGGER.error("Invalid response JSON: {}", responseJson);
            throw new RuntimeException(e.getMessage());
        }

        if (apiResponse.getError() != null) {
            LOGGER.error("API Error: {}", apiResponse.getError().toString());
            throw apiResponse.getError();
        }

        var response = apiResponse.getResponse();
        LOGGER.debug("API response: {}", response);
        return response;
    }
}
