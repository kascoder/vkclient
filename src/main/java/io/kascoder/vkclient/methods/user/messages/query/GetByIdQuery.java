package io.kascoder.vkclient.methods.user.messages.query;

import lombok.*;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.Query;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;
import java.util.Set;

@Value
@Builder
public class GetByIdQuery implements Query {
    @Param(name = "extended")
    boolean extended;
    @Param(name = "preview_length")
    Integer previewLength;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
    @NonNull
    @Param(name = "message_ids", strategy = ObjectCollectionConversionStrategy.class)
    Set<Integer> messageIdSet; // max 100, mandatory
}

