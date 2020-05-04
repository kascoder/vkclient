package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class DeleteQuery implements VkApiQuery {
    @Param(name = "spam")
    boolean spam;
    @Param(name = "delete_for_all")
    private boolean deleteForAll;
    @NonNull
    @Param(name = "message_ids", strategy = ObjectCollectionConversionStrategy.class)
    Set<Integer> messageIdSet;
}
