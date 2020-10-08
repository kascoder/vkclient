package io.kascoder.vkclient.util;

import lombok.Value;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Value
public class VideoID {
    String id;

    public static VideoID of(Integer ownerId, Integer videoId) {
        return of(new Object[]{ ownerId, videoId });
    }

    public static VideoID of(Integer ownerId, Integer videoId, String accessKey) {
        return of(new Object[]{ ownerId, videoId, accessKey });
    }

    private static VideoID of(Object ...args) {
        var id = Arrays.stream(args)
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining("_"));
        return new VideoID(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
