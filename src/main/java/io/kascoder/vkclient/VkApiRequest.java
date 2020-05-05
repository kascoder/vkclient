package io.kascoder.vkclient;

import lombok.*;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.HttpUtils;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VkApiRequest<T> {
    @NonNull
    private final Class<T> clazz;
    @NonNull
    private final VkApiQuery vkApiQuery;
    @NonNull
    private final Method method;
    @NonNull
    @Builder.Default private final HttpUtils.HttpMethod httpMethod = HttpUtils.HttpMethod.POST;
}
