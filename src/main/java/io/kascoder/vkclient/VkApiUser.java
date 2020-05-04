package io.kascoder.vkclient;

import io.kascoder.vkclient.methods.user.video.VideoApi;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import io.kascoder.vkclient.methods.user.messages.MessagesApi;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VkApiUser {
    public static final MessagesApi messages = new MessagesApi();
    public static final VideoApi video = new VideoApi();
}
