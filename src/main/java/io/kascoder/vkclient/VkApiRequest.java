package io.kascoder.vkclient;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import io.kascoder.vkclient.methods.VkAPiMethod;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.HttpUtils;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VkApiRequest<T> {
    private final Class<T> clazz;
    private final VkApiQuery query;
    private final VkAPiMethod vkAPiMethod;
    @Builder.Default private final HttpUtils.HttpMethod httpMethod = HttpUtils.HttpMethod.POST;
}
