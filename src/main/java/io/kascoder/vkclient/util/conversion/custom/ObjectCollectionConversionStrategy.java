package io.kascoder.vkclient.util.conversion.custom;

import lombok.NonNull;
import io.kascoder.vkclient.util.conversion.ConversionStrategy;

import java.util.Collection;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class ObjectCollectionConversionStrategy implements ConversionStrategy<Collection<Object>> {
    @Override
    public String convert(@NonNull Collection<Object> o) {
        return o.stream()
                .map(Objects::toString)
                .collect(joining(","));
    }
}
