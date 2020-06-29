package io.kascoder.vkclient.util.conversion.custom;

import lombok.NonNull;
import io.kascoder.vkclient.util.conversion.RequestParameterConverter;

import java.util.Collection;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class ObjectCollectionRequestParameterConverter implements RequestParameterConverter<Collection<Object>> {
    @Override
    public String convert(@NonNull Collection<Object> o) {
        return o.stream()
                .map(Objects::toString)
                .collect(joining(","));
    }
}
