package io.kascoder.vkclient.util.conversion.custom;

import java.time.format.DateTimeFormatter;

public class LocalDateDDMMYYYYRequestParameterConverter extends LocalDateRequestParameterConverter {
    public LocalDateDDMMYYYYRequestParameterConverter() {
        super(DateTimeFormatter.ofPattern("ddMMyyyy"));
    }
}
