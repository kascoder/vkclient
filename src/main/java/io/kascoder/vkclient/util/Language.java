package io.kascoder.vkclient.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

    private final int code;
}
