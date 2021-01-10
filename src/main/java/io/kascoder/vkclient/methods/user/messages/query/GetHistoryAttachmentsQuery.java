package io.kascoder.vkclient.methods.user.messages.query;

import io.kascoder.vkclient.domain.model.AttachmentType;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.IValueRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.custom.ObjectFieldListRequestParameterConverter;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GetHistoryAttachmentsQuery implements VkApiQuery {
    @RequestParameter(name = "peer_id")
    int peerId;
    @NonNull
    @RequestParameter(name = "media_type")
    @Converter(IValueRequestParameterConverter.class)
    @Builder.Default AttachmentType mediaType = AttachmentType.PHOTO;
    @RequestParameter(name = "start_from")
    Integer startFrom;
    @RequestParameter
    @Builder.Default int count = 30; // max 200
    @RequestParameter(name = "photo_sizes")
    boolean withPhotoSizes;
    @RequestParameter
    @Converter(ObjectFieldListRequestParameterConverter.class)
    List<ObjectField> fields;
    @RequestParameter(name = "preserve_order")
    boolean ordered;
}
