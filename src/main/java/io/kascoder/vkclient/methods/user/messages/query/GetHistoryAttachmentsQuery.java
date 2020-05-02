package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.domain.model.AttachmentType;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.IValueConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GetHistoryAttachmentsQuery implements VkApiQuery {
    @Param(name = "peer_id")
    int peerId;
    @NonNull
    @Param(name = "media_type", strategy = IValueConversionStrategy.class)
    @Builder.Default AttachmentType mediaType = AttachmentType.PHOTO;
    @Param(name = "start_from")
    Integer startFrom;
    @Param(name = "count")
    @Builder.Default int count = 30; // max 200
    @Param(name = "photo_sizes")
    boolean withPhotoSizes;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    List<ObjectField> fields;
    @Param(name = "preserve_order")
    boolean ordered;
}
