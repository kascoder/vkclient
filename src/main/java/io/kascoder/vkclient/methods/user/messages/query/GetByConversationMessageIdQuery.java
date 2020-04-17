package io.kascoder.vkclient.methods.user.messages.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetByConversationMessageIdQuery implements VkApiQuery {
    @Param(name = "peer_id")
    private final Integer peerId;
    @Param(name = "extended")
    private final boolean extended;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    private final List<ObjectField> fields;
    @Param(name = "conversation_message_ids", strategy = ObjectCollectionConversionStrategy.class)
    private final Set<Integer> conversationMessageIdSet; // max 100
}

