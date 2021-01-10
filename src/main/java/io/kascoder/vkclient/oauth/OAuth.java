package io.kascoder.vkclient.oauth;

import io.kascoder.vkclient.util.Parameterizable;
import io.kascoder.vkclient.util.annotation.RequestParameter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OAuth implements Parameterizable {
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class User extends OAuth {
        @Getter
        @RequiredArgsConstructor
        public static class PasswordFlow extends User {
            @RequestParameter(name = "client_id")
            private final int clientId;
            @RequestParameter(name = "client_secret")
            private final String clientSecret;
            @RequestParameter(name = "username")
            private final String username;
            @RequestParameter(name = "password")
            private final String password;
            @RequestParameter(name = "grant_type")
            private final String grantType = "password";
        }
    }
}
