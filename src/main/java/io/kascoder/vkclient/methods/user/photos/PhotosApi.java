package io.kascoder.vkclient.methods.user.photos;

import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.user.photos.query.GetAlbumsQuery;
import io.kascoder.vkclient.methods.user.photos.query.GetQuery;
import io.kascoder.vkclient.methods.user.photos.response.AlbumListResponse;
import io.kascoder.vkclient.methods.user.photos.response.PhotoListResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class PhotosApi {
    public VkApiRequest<AlbumListResponse> getAlbums(@NonNull GetAlbumsQuery query) {
        return VkApiRequest.<AlbumListResponse>builder()
                .method(Methods.getAlbums)
                .vkApiQuery(query)
                .clazz(AlbumListResponse.class)
                .build();
    }

    public VkApiRequest<PhotoListResponse> get(@NonNull GetQuery query) {
        return VkApiRequest.<PhotoListResponse>builder()
                .method(Methods.get)
                .vkApiQuery(query)
                .clazz(PhotoListResponse.class)
                .build();
    }

    @AllArgsConstructor
    enum Methods implements Method {
        get("get"),
        getAlbums("getAlbums");

        private final String path;

        @Override
        public String path() {
            return "photos." + path;
        }
    }
}
