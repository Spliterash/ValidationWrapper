package ru.spliterash.validationWrapper.annotation;

import java.lang.annotation.*;

/**
 * Название параметра в свободной форме
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Name {
    String value();

    String info() default "";
}
