package io.kascoder.vkclient.methods.user.video;

import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.domain.model.VideoAlbum;
import io.kascoder.vkclient.methods.Method;
import io.kascoder.vkclient.methods.user.video.query.GetAlbumByIdQuery;
import io.kascoder.vkclient.methods.user.video.query.GetAlbumsQuery;
import io.kascoder.vkclient.methods.user.video.query.GetQuery;
import io.kascoder.vkclient.methods.user.video.response.VideoAlbumListResponse;
import io.kascoder.vkclient.methods.user.video.response.VideoListResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class VideoApi {
    public VkApiRequest<VideoListResponse> get(@NonNull GetQuery query) {
        return VkApiRequest.<VideoListResponse>builder()
                .method(Methods.get)
                .vkApiQuery(query)
                .clazz(VideoListResponse.class)
                .build();
    }

    public VkApiRequest<VideoAlbumListResponse> getAlbums(@NonNull GetAlbumsQuery query) {
        return VkApiRequest.<VideoAlbumListResponse>builder()
                .method(Methods.getAlbums)
                .vkApiQuery(query)
                .clazz(VideoAlbumListResponse.class)
                .build();
    }

    public VkApiRequest<VideoAlbum> getAlbumById(@NonNull GetAlbumByIdQuery query) {
        return VkApiRequest.<VideoAlbum>builder()
                .method(Methods.getAlbumById)
                .vkApiQuery(query)
                .clazz(VideoAlbum.class)
                .build();
    }

    @AllArgsConstructor
    enum Methods implements Method {
        get("get"),
        getAlbums("getAlbums"),
        getAlbumById("getAlbumById");

        private final String path;

        @Override
        public String path() {
            return "video." + path;
        }
    }
}
