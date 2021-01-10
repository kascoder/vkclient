package io.kascoder.vkclient.domain.model;

import io.kascoder.vkclient.domain.IValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum FeedType implements IValue {
    PHOTO("photo"),
    PHOTO_TAG("photo_tag");

    private final String value;
}
