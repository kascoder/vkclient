package io.kascoder.vkclient.util.conversion.custom;

import io.kascoder.vkclient.util.conversion.RequestParameterConverter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
abstract class LocalDateRequestParameterConverter implements RequestParameterConverter<LocalDate> {
    @NonNull
    private final DateTimeFormatter dateTimeFormatter;

    @Override
    public final String convert(@NonNull LocalDate o) {
        return dateTimeFormatter.format(o);
    }
}
