package io.kascoder.vkclient.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Simple marker
 */
@Retention(RetentionPolicy.SOURCE)
@Target(value = ElementType.TYPE)
public @interface ApiObjectDefinition {
    String name();
}
