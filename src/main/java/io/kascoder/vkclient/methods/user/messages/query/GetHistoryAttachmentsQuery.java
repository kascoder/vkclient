package io.kascoder.vkclient.methods.user.messages.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import io.kascoder.vkclient.domain.model.AttachmentType;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.IValueConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListConversionStrategy;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetHistoryAttachmentsQuery implements VkApiQuery {
    @Param(name = "peer_id")
    private final int peerId;
    @Param(name = "media_type", strategy = IValueConversionStrategy.class)
    @Builder.Default private final AttachmentType mediaType = AttachmentType.PHOTO;
    @Param(name = "start_from")
    private final Integer startFrom;
    @Param(name = "count")
    @Builder.Default private final int count = 30;
    @Param(name = "photo_sizes")
    private final Boolean withPhotoSizes;
    @Param(name = "fields", strategy = ObjectFieldListConversionStrategy.class)
    private final List<ObjectField> fields;
    @Param(name = "preserve_order")
    private final Boolean ordered;
}
