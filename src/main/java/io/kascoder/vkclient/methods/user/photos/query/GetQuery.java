package io.kascoder.vkclient.methods.user.photos.query;

import io.kascoder.vkclient.domain.model.FeedType;
import io.kascoder.vkclient.domain.model.PhotoAlbumType;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.IValueConversionStrategy;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class GetQuery implements VkApiQuery {
    @Param(name = "owner_id")
    Integer ownerId; // default value is current user id
    @Param(name = "photo_ids", strategy = ObjectCollectionConversionStrategy.class)
    Set<Integer> photos;
    @Param(name = "offset")
    int offset;
    @Param(name = "count")
    @Builder.Default int count = 50; // max value is 1000
    @Param(name = "extended")
    boolean extended;
    @Param(name = "rev")
    boolean reverse;
    @Param(name = "photo_sizes")
    boolean photoSizes;
    @Param(name = "feed_type", strategy = IValueConversionStrategy.class)
    FeedType feedType;
    @Param(name = "feed")
    Integer feed;
    @NonNull
    @Param(name = "album_id", strategy = IValueConversionStrategy.class)
    PhotoAlbumType album;
}
