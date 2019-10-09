package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.entity.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public class AuthorFetcher implements GraphQLFetcher {
    @Override
    public String fieldName() {
        return "author";
    }

    @Override
    public String typeName() {
        return "Book";
    }

    @Override
    public DataFetcher dataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return book.getAuthor();
        };
    }
}
