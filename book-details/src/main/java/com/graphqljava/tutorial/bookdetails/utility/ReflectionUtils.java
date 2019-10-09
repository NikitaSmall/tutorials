package com.graphqljava.tutorial.bookdetails.utility;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class ReflectionUtils {
    @SneakyThrows
    public static String getFieldName(Field field) {
        return field.getName();
    }

    public static Object getValue(Field field, Object obj) {
        return getFieldInternal(field, obj);
    }

    @SneakyThrows
    private static Object getFieldInternal(Field field, Object obj) {
        boolean access = accessField(field);
        Object value = field.get(obj);
        field.setAccessible(access);
        return value;
    }

    //todo: deprecated since 9?
    private static boolean accessField(Field f) {
        boolean access = f.isAccessible();
        f.setAccessible(true);
        return access;
    }
}
