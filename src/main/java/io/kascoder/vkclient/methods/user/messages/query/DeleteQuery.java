package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionRequestParameterConverter;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class DeleteQuery implements VkApiQuery {
    @RequestParameter
    boolean spam;
    @RequestParameter(name = "delete_for_all")
    boolean deleteForAll;
    @NonNull
    @RequestParameter(name = "message_ids")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<Integer> messageIdSet;
}
