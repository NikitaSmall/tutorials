package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.services.interfaces.BookService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookByPageCntFetcher implements GraphQLFetcher {
    @Autowired
    private BookService bookService;

    @Override
    public String fieldName() {
        return "bookByPageCount";
    }

    @Override
    public String typeName() {
        return "Query";
    }

    @Override
    public DataFetcher dataFetcher() {
        return environment -> {
            int pageCnt = environment.getArgument("pageCount");
            return bookService.findByPageCount(pageCnt);
        };
    }
}
