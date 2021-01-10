package io.kascoder.vkclient.domain.model;

import io.kascoder.vkclient.domain.IValue;
import lombok.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotoAlbumType implements IValue {
    private final String value;

    public static PhotoAlbumType custom(int id) {
        return new PhotoAlbumType(String.valueOf(id));
    }

    public static PhotoAlbumType wall() {
        return new PhotoAlbumType("wall");
    }

    public static PhotoAlbumType profile() {
        return new PhotoAlbumType("profile");
    }

    public static PhotoAlbumType saved() {
        return new PhotoAlbumType("saved");
    }
}
