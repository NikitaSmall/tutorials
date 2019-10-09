package com.graphqljava.tutorial.bookdetails.mutators;

import graphql.schema.DataFetcher;

public interface GraphQLMutator {
    String mutationName();
    DataFetcher dataFetcher();

    default String typeName() {
        return "Mutation";
    }
}
