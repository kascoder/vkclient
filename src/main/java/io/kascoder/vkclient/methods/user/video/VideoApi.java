package io.kascoder.vkclient.methods.user.video;

import io.kascoder.vkclient.VkApiRequest;
import io.kascoder.vkclient.methods.VkAPiMethod;
import io.kascoder.vkclient.methods.user.video.query.GetQuery;
import io.kascoder.vkclient.methods.user.video.response.VideoListResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;

public class VideoApi {
    public VkApiRequest<VideoListResponse> get(@NonNull GetQuery query) {
        return VkApiRequest.<VideoListResponse>builder()
                .vkAPiMethod(Methods.get)
                .query(query)
                .clazz(VideoListResponse.class)
                .build();
    }

    @AllArgsConstructor
    enum Methods implements VkAPiMethod {
        get("get");

        private final String path;

        @Override
        public String path() {
            return "video." + path;
        }
    }
}
