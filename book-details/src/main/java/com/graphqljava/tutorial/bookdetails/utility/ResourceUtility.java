package com.graphqljava.tutorial.bookdetails.utility;

import com.google.common.io.Resources;
import lombok.SneakyThrows;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.io.Resources.getResource;

public class ResourceUtility {
    @SneakyThrows
    public static String stringResource(String path) {
        return Resources.toString(getResource(path), UTF_8);
    }
}
