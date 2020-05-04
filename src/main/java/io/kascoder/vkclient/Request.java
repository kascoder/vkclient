package io.kascoder.vkclient;

import lombok.*;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.Query;
import io.kascoder.vkclient.util.HttpUtils;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Request<T> {
    @NonNull
    private final Class<T> clazz;
    @NonNull
    private final Query query;
    @NonNull
    private final Method method;
    @NonNull
    @Builder.Default private final HttpUtils.HttpMethod httpMethod = HttpUtils.HttpMethod.POST;
}
