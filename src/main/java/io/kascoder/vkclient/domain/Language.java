package io.kascoder.vkclient.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Language {
    RUSSIAN(0),
    UKRAINIAN(1),
    BELORUSSIAN(2),
    ENGLISH(3),
    SPANISH(4),
    FINNISH(5),
    GERMAN(6),
    ITALIAN(7);

    @JsonValue
    private final int code;

    @JsonCreator
    public static Language from(int code) {
        return Arrays.stream(values())
                .filter(t -> t.code == code)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unknown code: " + code));
    }
}
