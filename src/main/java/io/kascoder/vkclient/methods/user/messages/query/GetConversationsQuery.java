package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.util.annotation.Converter;
import lombok.*;
import io.kascoder.vkclient.methods.ConversationFilter;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.IValueRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;

import java.util.List;

@Value
@Builder
public class GetConversationsQuery implements VkApiQuery {
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 20;
    @RequestParameter
    @Converter(IValueRequestParameterConverter.class)
    @Builder.Default ConversationFilter filter = ConversationFilter.ALL;
    @RequestParameter
    boolean extended;
    @RequestParameter(name = "start_message_id")
    Integer startMessageId;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
}

