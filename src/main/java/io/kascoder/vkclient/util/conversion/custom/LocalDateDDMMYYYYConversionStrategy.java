package io.kascoder.vkclient.util.conversion.custom;

import java.time.format.DateTimeFormatter;

public class LocalDateDDMMYYYYConversionStrategy extends LocalDateConversionStrategy {
    public LocalDateDDMMYYYYConversionStrategy() {
        super(DateTimeFormatter.ofPattern("ddMMyyyy"));
    }
}
