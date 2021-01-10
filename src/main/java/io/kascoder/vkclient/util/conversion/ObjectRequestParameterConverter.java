package io.kascoder.vkclient.util.conversion;

import lombok.NonNull;

public class ObjectRequestParameterConverter implements RequestParameterConverter<Object> {
    @Override
    public String convert(@NonNull Object o) {
        return o.toString();
    }
}
