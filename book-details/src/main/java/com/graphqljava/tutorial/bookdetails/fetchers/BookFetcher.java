package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookFetcher implements GraphQLFetcher {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String fieldName() {
        return "bookById";
    }

    @Override
    public String typeName() {
        return "Query";
    }

    @Override
    public DataFetcher dataFetcher() {
        return environment -> {
            String bookId = environment.getArgument("id");
            return bookRepository.findById(Integer.parseInt(bookId));
        };
    }
}
