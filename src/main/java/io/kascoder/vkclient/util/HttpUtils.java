package io.kascoder.vkclient.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpUtils {
    public enum HttpMethod {
        GET, POST
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<String, Object> formData) {
        Objects.requireNonNull(formData);

        var builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : formData.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder
                    .append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            builder.append("=");
            builder
                    .append(URLEncoder.encode(entry
                            .getValue()
                            .toString(), StandardCharsets.UTF_8));
        }

        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}
