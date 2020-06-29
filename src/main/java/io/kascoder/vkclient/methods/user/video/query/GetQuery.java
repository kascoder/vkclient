package io.kascoder.vkclient.methods.user.video.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.VideoID;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionRequestParameterConverter;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class GetQuery implements VkApiQuery {
    @RequestParameter(name = "owner_id")
    Integer ownerId;
    @RequestParameter(name = "videos")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<VideoID> videoIdSet;
    @RequestParameter(name = "album_id")
    Integer albumId;
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 100; // max 200
    @RequestParameter
    boolean extended;
}
