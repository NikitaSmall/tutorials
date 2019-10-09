package com.graphqljava.tutorial.bookdetails.fetchers;

import graphql.schema.DataFetcher;

public interface GraphQLFetcher {
    String fieldName();
    String typeName();
    DataFetcher dataFetcher();
}
