package io.kascoder.vkclient.methods.user.photos.query;

import io.kascoder.vkclient.domain.model.FeedType;
import io.kascoder.vkclient.domain.model.PhotoAlbumType;
import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.IValueRequestParameterConverter;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionRequestParameterConverter;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class GetQuery implements VkApiQuery {
    @RequestParameter(name = "owner_id")
    Integer ownerId; // default value is current user id
    @RequestParameter(name = "photo_ids")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<Integer> photos;
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 50; // max value is 1000
    @RequestParameter
    boolean extended;
    @RequestParameter(name = "rev")
    boolean reverse;
    @RequestParameter(name = "photo_sizes")
    boolean photoSizes;
    @RequestParameter(name = "feed_type")
    @Converter(IValueRequestParameterConverter.class)
    FeedType feedType;
    @RequestParameter
    Integer feed;
    @NonNull
    @RequestParameter(name = "album_id")
    @Converter(IValueRequestParameterConverter.class)
    PhotoAlbumType album;
}
