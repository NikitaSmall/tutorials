package com.graphqljava.tutorial.bookdetails;

import com.google.common.collect.ImmutableMap;
import com.graphqljava.tutorial.bookdetails.repository.graphql.GraphQLAuthorRepo;
import com.graphqljava.tutorial.bookdetails.repository.graphql.GraphQLBookRepo;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {
    @Autowired
    private GraphQLBookRepo bookRepo;
    @Autowired
    private GraphQLAuthorRepo authorRepo;

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return bookRepo
                    .findAll()
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authorRepo
                    .findAll()
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
