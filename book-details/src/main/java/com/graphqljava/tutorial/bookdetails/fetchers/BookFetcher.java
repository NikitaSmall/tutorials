package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import com.graphqljava.tutorial.bookdetails.services.interfaces.BookService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Integer.parseInt;

@Component
public class BookFetcher implements GraphQLFetcher {
    @Autowired
    private BookService bookService;

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
            return bookService.findById(parseInt(bookId));
        };
    }
}
