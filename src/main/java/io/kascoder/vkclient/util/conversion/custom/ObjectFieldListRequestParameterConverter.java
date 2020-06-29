package io.kascoder.vkclient.util.conversion.custom;

import lombok.NonNull;
import io.kascoder.vkclient.methods.ObjectField;
import io.kascoder.vkclient.util.conversion.RequestParameterConverter;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class ObjectFieldListRequestParameterConverter implements RequestParameterConverter<List<ObjectField>> {
    @Override
    public String convert(@NonNull List<ObjectField> o) {
        return o.stream()
                .map(Objects::toString)
                .collect(joining(","));
    }
}
