package io.kascoder.vkclient.methods.user.video.query;

import io.kascoder.vkclient.methods.VkApiQuery;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetAlbumByIdQuery implements VkApiQuery {
    @RequestParameter(name = "owner_id")
    Integer ownerId; // default value is current user id
    @RequestParameter(name = "album_id")
    int albumId;
}
