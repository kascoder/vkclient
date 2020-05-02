package io.kascoder.vkclient;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kascoder.vkclient.oauth.OAuth;
import io.kascoder.vkclient.oauth.OAuthError;
import io.kascoder.vkclient.oauth.OAuthResponse;
import io.kascoder.vkclient.util.DefaultApiParams;
import io.kascoder.vkclient.util.HttpUtils;
import io.kascoder.vkclient.util.ParameterBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class VkApiClient {
    @Getter
    @NonNull
    private final String accessToken;
    @Getter
    @NonNull
    private final Integer userId;
    @NonNull
    private final HttpClient httpClient;

    public VkApiClient(String accessToken, Integer userId) {
        this(accessToken, userId, HttpClient.newHttpClient());
    }

    public <T> CompletableFuture<T> executeRequest(@NonNull VkApiRequest<T> request) {
        var method = request.getHttpMethod();
        var vkAPiMethod = request.getVkAPiMethod();
        var vkApiQuery = request.getQuery();

        var params = new HashMap<>(ParameterBuilder.buildParamMap(vkApiQuery));
        params.put("access_token", accessToken);
        params.put("v", DefaultApiParams.API_VERSION);

        var httpRequest = HttpRequest.newBuilder(URI.create(DefaultApiParams.API_URL + vkAPiMethod.path()))
                .method(method.toString(), HttpUtils.ofFormData(params))
                .build();

        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> parseMethodResponse(body, request.getClazz()));
    }

    public static VkApiClient byOAuth(OAuth authData) {
        return byOAuth(HttpClient.newHttpClient(), authData);
    }

    public static VkApiClient byOAuth(@NonNull HttpClient httpClient, @NonNull OAuth authData) {
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

        return new VkApiClient(response.getAccessToken(), response.getUserId(), httpClient);
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
        VkApiResponse<T> vkApiResponse;
        try {
            var mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructParametricType(VkApiResponse.class, clazz);
            vkApiResponse = mapper.readValue(response, type);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if (vkApiResponse.getError() != null) {
            throw vkApiResponse.getError();
        }

        return vkApiResponse.getResponse();
    }
}
