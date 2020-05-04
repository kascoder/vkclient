package io.kascoder.vkclient.methods.user.messages.query;

import lombok.*;
import io.kascoder.vkclient.methods.ConversationFilter;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.IValueConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;

@Value
@Builder
public class GetConversationsQuery implements VkApiQuery {
    @Param(name = "offset")
    int offset;
    @Param(name = "count")
    @Builder.Default int count = 20;
    @Param(name = "filter", strategy = IValueConversionStrategy.class)
    @Builder.Default ConversationFilter filter = ConversationFilter.ALL;
    @Param(name = "extended")
    boolean extended;
    @Param(name = "start_message_id")
    Integer startMessageId;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
}

