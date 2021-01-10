package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
@Builder
public class GetByConversationMessageIdQuery implements VkApiQuery {
    @RequestParameter(name = "peer_id")
    int peerId;
    @RequestParameter
    boolean extended;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
    @NonNull
    @RequestParameter(name = "conversation_message_ids")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<Integer> conversationMessageIdSet; // max 100
}

