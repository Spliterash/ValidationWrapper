package ru.spliterash.validationWrapper;

import ru.spliterash.validationWrapper.annotation.Name;

import java.lang.reflect.Field;

public class NameUtils {
    public static String name(Field field) {
        Name annotation = field.getAnnotation(Name.class);
        if (annotation != null)
            return annotation.value();
        else
            return field.getName();
    }

    public static String name(Class<?> clazz) {
        Name annotation = clazz.getAnnotation(Name.class);

        if (annotation != null)
            return annotation.value();
        else
            return clazz.getSimpleName();
    }

    public static String info(Class<?> clazz) {
        Name annotation = clazz.getAnnotation(Name.class);

        if (annotation != null)
            return annotation.info();
        else
            return "";
    }
}
