package io.kascoder.vkclient.util.conversion;

import lombok.NonNull;

public interface RequestParameterConverter<T> {
    String convert(@NonNull T o);

    default String convert(int o) {
        return Integer.toString(o);
    }

    default String convert(boolean o) {
        return Boolean.toString(o);
    }

    default String convert(@NonNull String o) {
        return o;
    }
}
