package io.kascoder.vkclient.util.annotation;

import io.kascoder.vkclient.util.conversion.ConversionStrategy;
import io.kascoder.vkclient.util.conversion.ObjectConversionStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Param {
    Class<? extends ConversionStrategy<?>> strategy() default ObjectConversionStrategy.class;
    String name();
}
