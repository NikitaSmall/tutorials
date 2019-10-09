package com.graphqljava.tutorial.bookdetails.utility;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class StreamUtils {
    public static <T, U> List<U> mapList(List<T> initialList, Function<? super T, ? extends U> mapper) {
        return initialList
                .stream()
                .map(mapper)
                .collect(toList());
    }

    public static <T> List<T> filterList(List<T> initialList, Predicate<? super T> predicate) {
        return initialList
                .stream()
                .filter(predicate)
                .collect(toList());
    }

    public static <T> T filterFirst(List<T> initialList, Predicate<? super T> predicate) {
        return initialList
                .stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
