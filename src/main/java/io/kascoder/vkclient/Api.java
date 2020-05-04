package io.kascoder.vkclient;

import io.kascoder.vkclient.methods.user.video.VideoApi;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import io.kascoder.vkclient.methods.user.messages.MessagesApi;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Api {
    public static final MessagesApi messages = new MessagesApi();
    public static final VideoApi video = new VideoApi();
}
