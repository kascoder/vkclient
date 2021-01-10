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
public class GetConversationsByIdQuery implements VkApiQuery {
    @NonNull
    @RequestParameter(name = "peer_ids")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<Integer> peerIdSet; // max - 1000
    @RequestParameter
    boolean extended;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
}

