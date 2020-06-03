package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
@Builder
public class GetConversationsByIdQuery implements VkApiQuery {
    @NonNull
    @Param(name = "peer_ids", strategy = ObjectCollectionConversionStrategy.class)
    Set<Integer> peerIdSet; // max - 1000
    @Param(name = "extended")
    boolean extended;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
}

