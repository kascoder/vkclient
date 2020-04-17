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
public class GetByIdQuery implements VkApiQuery {
    @Param(name = "extended")
    private final boolean extended;
    @Param(name = "preview_length")
    private final Integer previewLength;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    private final List<ObjectField> fields;
    @Param(name = "message_ids", strategy = ObjectCollectionConversionStrategy.class)
    private final Set<Integer> messageIdSet; // max 100, mandatory
}

