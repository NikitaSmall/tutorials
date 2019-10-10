package com.graphqljava.tutorial.bookdetails.mutators;

import com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorDto;
import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.services.interfaces.AuthorService;
import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateAuthorResolver implements GraphQLMutator {
    private final AuthorService authorService;

    @Override
    public String mutationName() {
        return "createAuthor";
    }

    @Override
    public DataFetcher dataFetcher() {
        return environment -> {
            String firstName = environment.getArgument("firstName");
            String lastName = environment.getArgument("lastName");
            return authorService.createAuthor(new CreateAuthorDto(firstName, lastName));
        };
    }
}
