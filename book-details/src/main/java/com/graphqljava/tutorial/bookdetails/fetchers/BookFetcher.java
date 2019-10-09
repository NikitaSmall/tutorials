package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.entity.Book;
import com.graphqljava.tutorial.bookdetails.repository.graphql.GraphQLRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.graphqljava.tutorial.bookdetails.utility.StreamUtils.filterFirst;

@Component
public class BookFetcher implements GraphQLFetcher {
    @Autowired
    private GraphQLRepository graphQLRepository;

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
            return filterFirst(graphQLRepository.findAll(Book.class), book -> book.get("id").equals(bookId));
        };
    }
}
