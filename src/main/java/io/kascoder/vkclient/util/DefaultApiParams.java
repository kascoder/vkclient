package io.kascoder.vkclient.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultApiParams {
    public static final String API_VERSION = "5.103";
    public static final String API_URL = "https://api.vk.com/method/";
    public static final String OAUTH_URL = "https://oauth.vk.com/access_token/";
}
