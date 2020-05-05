package io.kascoder.vkclient.methods.user;

import io.kascoder.vkclient.methods.ObjectField;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AccountInfoField implements ObjectField {
    COUNTRY("country"),
    HTTPS_REQUIRED("https_required"),
    OWN_POSTS_DEFAULT("own_posts_default"),
    NO_WALL_REPLIES("no_wall_replies"),
    INTRO("intro"),
    LANG("lang");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
