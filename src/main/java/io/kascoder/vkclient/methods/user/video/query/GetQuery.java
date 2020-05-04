package io.kascoder.vkclient.methods.user.video.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.VideoID;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class GetQuery implements VkApiQuery {
    @Param(name = "owner_id")
    Integer ownerId;
    @Param(name = "videos", strategy = ObjectCollectionConversionStrategy.class)
    Set<VideoID> videoIdSet;
    @Param(name = "album_id")
    Integer albumId;
    @Param(name = "offset")
    int offset;
    @Param(name = "count")
    @Builder.Default int count = 100; // max 200
    @Param(name = "extended")
    boolean extended;
}
