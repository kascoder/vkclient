package io.kascoder.vkclient.oauth;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import io.kascoder.vkclient.util.IParam;
import io.kascoder.vkclient.util.annotation.Param;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OAuth implements IParam {
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class User extends OAuth {
        @Getter
        @RequiredArgsConstructor
        public static class PasswordFlow extends User {

            @Param(name = "client_id")
            private final int clientId;
            @Param(name = "client_secret")
            private final String clientSecret;
            @Param(name = "username")
            private final String username;
            @Param(name = "password")
            private final String password;
            @Param(name = "grant_type")
            private String grantType = "password";
        }
    }
}
