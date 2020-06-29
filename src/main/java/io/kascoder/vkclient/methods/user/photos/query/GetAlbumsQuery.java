package io.kascoder.vkclient.methods.user.photos.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Param;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionConversionStrategy;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class GetAlbumsQuery implements VkApiQuery {
    @Param(name = "owner_id")
    Integer ownerId; // default value is current user id
    @Param(name = "album_ids", strategy = ObjectCollectionConversionStrategy.class)
    Set<Integer> albums;
    @Param(name = "offset")
    int offset;
    @Param(name = "count")
    @Builder.Default int count = 20;
    @Param(name = "need_system")
    boolean needSystem;
    @Param(name = "need_covers")
    boolean needCovers;
    @Param(name = "photo_sizes")
    boolean photoSizes;
}
