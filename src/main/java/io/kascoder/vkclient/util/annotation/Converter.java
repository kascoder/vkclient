package io.kascoder.vkclient.util.annotation;

import io.kascoder.vkclient.util.conversion.RequestParameterConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Converter {
    Class<? extends RequestParameterConverter<?>> value();
}
