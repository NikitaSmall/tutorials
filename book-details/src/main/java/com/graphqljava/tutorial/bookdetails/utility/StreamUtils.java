package com.graphqljava.tutorial.bookdetails.utility;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class StreamUtils {
    public static <T, U> List<U> mapList(List<T> initialList, Function<? super T, ? extends U> mapper) {
        return initialList
                .stream()
                .map(mapper)
                .collect(toList());
    }
}
