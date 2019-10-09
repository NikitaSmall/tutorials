package com.graphqljava.tutorial.bookdetails.fetchers;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorResolver implements GraphQLFetcher {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String fieldName() {
        return "createAuthor";
    }

    @Override
    public String typeName() {
        return "Query";
    }

    @Override
    public DataFetcher dataFetcher() {
        return environment -> {
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            return authorRepository.save(new Author(firstName, lastName));
        };
    }
}
