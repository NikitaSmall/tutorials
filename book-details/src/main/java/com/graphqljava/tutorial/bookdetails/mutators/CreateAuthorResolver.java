package com.graphqljava.tutorial.bookdetails.mutators;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorResolver implements GraphQLMutator {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String mutationName() {
        return "createAuthor";
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
