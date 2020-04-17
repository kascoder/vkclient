package io.kascoder.vkclient.methods.user.messages.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import io.kascoder.vkclient.methods.ConversationFilter;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.IValueConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetConversationsQuery implements VkApiQuery {
    @Param(name = "offset")
    private final int offset;
    @Param(name = "count")
    @Builder.Default private final int count = 20;
    @Param(name = "filter", strategy = IValueConversionStrategy.class)
    @Builder.Default private final ConversationFilter filter = ConversationFilter.ALL;
    @Param(name = "extended")
    private final boolean extended;
    @Param(name = "start_message_id")
    private final Integer startMessageId;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    private final List<ObjectField> fields;
}

