package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class SearchConversationsQuery implements VkApiQuery {
    @RequestParameter
    String q;
    @RequestParameter
    @Builder.Default int count = 20;
    @RequestParameter
    boolean extended;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
}
