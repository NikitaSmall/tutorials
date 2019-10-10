package com.graphqljava.tutorial.bookdetails.mocks.environment;

import graphql.schema.DataFetchingEnvironment;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Mockito.when;

public class EnvironmentMocks {
    public static DataFetchingEnvironment argumentEnvironment(Map<String, Object> argumentsMap) {
        DataFetchingEnvironment dataFetchingEnvironment = Mockito.mock(DataFetchingEnvironment.class);

        argumentsMap.forEach((k, v) -> when(dataFetchingEnvironment.getArgument(k)).thenReturn(v));
        when(dataFetchingEnvironment.getArguments()).thenReturn(argumentsMap);

        return dataFetchingEnvironment;
    }
}
