package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.util.annotation.Converter;
import lombok.*;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;

import java.util.List;
import java.util.Set;

@Value
@Builder
public class GetByIdQuery implements VkApiQuery {
    @RequestParameter
    boolean extended;
    @RequestParameter(name = "preview_length")
    Integer previewLength;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
    @NonNull
    @RequestParameter(name = "message_ids")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<Integer> messageIdSet; // max 100, mandatory
}

