package io.kascoder.vkclient;

import lombok.*;
import io.kascoder.vkclient.methods.VkAPiMethod;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.HttpUtils;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VkApiRequest<T> {
    @NonNull
    private final Class<T> clazz;
    @NonNull
    private final VkApiQuery query;
    @NonNull
    private final VkAPiMethod vkAPiMethod;
    @NonNull
    @Builder.Default private final HttpUtils.HttpMethod httpMethod = HttpUtils.HttpMethod.POST;
}
