package io.kascoder.vkclient.methods.user.photos.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.Converter;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import io.kascoder.vkclient.util.conversion.custom.ObjectCollectionRequestParameterConverter;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class GetAlbumsQuery implements VkApiQuery {
    @RequestParameter(name = "owner_id")
    Integer ownerId; // default value is current user id
    @RequestParameter(name = "album_ids")
    @Converter(ObjectCollectionRequestParameterConverter.class)
    Set<Integer> albums;
    @RequestParameter
    int offset;
    @RequestParameter
    @Builder.Default int count = 20;
    @RequestParameter(name = "need_system")
    boolean needSystem;
    @RequestParameter(name = "need_covers")
    boolean needCovers;
    @RequestParameter(name = "photo_sizes")
    boolean photoSizes;
}
