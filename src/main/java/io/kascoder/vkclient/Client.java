package io.kascoder.vkclient;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kascoder.vkclient.oauth.OAuth;
import io.kascoder.vkclient.oauth.OAuthError;
import io.kascoder.vkclient.oauth.OAuthResponse;
import io.kascoder.vkclient.util.DefaultApiParams;
import io.kascoder.vkclient.util.HttpUtils;
import io.kascoder.vkclient.domain.Language;
import io.kascoder.vkclient.util.ParameterBuilder;
import lombok.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Client {

    private static final HttpClient DEFAULT_HTTP_CLIENT = HttpClient.newHttpClient();

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

    public <T> CompletableFuture<T> executeRequest(@NonNull Request<T> request) {
        return executeRequest(request, language);
    }

    public <T> CompletableFuture<T> executeRequest(@NonNull Request<T> request, Language language) {
        var method = request.getHttpMethod();
        var vkAPiMethod = request.getMethod();
        var vkApiQuery = request.getQuery();

        var params = new HashMap<>(ParameterBuilder.buildParamMap(vkApiQuery));
        params.put("access_token", accessToken);
        params.put("v", DefaultApiParams.API_VERSION);
        if (language != null) {
            params.put("lang", language.getCode());
        }

        var httpRequest = HttpRequest.newBuilder(URI.create(DefaultApiParams.API_URL + vkAPiMethod.path()))
                .method(method.toString(), HttpUtils.ofFormData(params))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseMethodResponse(body, request.getClazz()));
    }

    public static Client byOAuth(OAuth authData) {
        return byOAuth(DEFAULT_HTTP_CLIENT, authData, null);
    }

    public static Client byOAuth(OAuth authData, Language language) {
        return byOAuth(DEFAULT_HTTP_CLIENT, authData, language);
    }

    public static Client byOAuth(HttpClient httpClient, @NonNull OAuth authData) {
        return byOAuth(httpClient, authData, null);
    }

    public static Client byOAuth(@NonNull HttpClient httpClient, @NonNull OAuth authData, Language language) {
        var httpRequest = HttpRequest.newBuilder(URI.create(DefaultApiParams.OAUTH_URL))
                .POST(HttpUtils.ofFormData(ParameterBuilder.buildParamMap(authData)))
                .build();

        HttpResponse<String> httpResponse;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        var response = parseOAuthResponse(httpResponse.body());

        return Client.builder()
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
            var accessToken = jsonNode.get("access_token");
            if (accessToken == null) {
                throw mapper.readValue(response, OAuthError.class);
            }

            return mapper.readValue(response, OAuthResponse.class);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    private <T> T parseMethodResponse(String response, Class<T> clazz) {
        Response<T> apiResponse;
        try {
            var mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(Response.class, clazz);
            apiResponse = mapper.readValue(response, type);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if (apiResponse.getError() != null) {
            throw apiResponse.getError();
        }

        return apiResponse.getResponse();
    }
}
