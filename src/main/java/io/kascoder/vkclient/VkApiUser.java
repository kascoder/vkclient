package io.kascoder.vkclient;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import io.kascoder.vkclient.methods.user.messages.MessagesApi;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VkApiUser {
    public static final MessagesApi messages = new MessagesApi();
}
