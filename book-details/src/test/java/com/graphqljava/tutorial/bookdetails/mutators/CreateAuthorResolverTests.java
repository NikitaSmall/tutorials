package com.graphqljava.tutorial.bookdetails.mutators;

import com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorDto;
import com.graphqljava.tutorial.bookdetails.mocks.environment.EnvironmentMocks;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import com.graphqljava.tutorial.bookdetails.services.implementations.DefaultBookService;
import com.graphqljava.tutorial.bookdetails.services.interfaces.AuthorService;
import com.graphqljava.tutorial.bookdetails.services.interfaces.BookService;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorDto.dto;
import static com.graphqljava.tutorial.bookdetails.entity.Book.noAuthorBook;
import static com.graphqljava.tutorial.bookdetails.mocks.environment.EnvironmentMocks.argumentEnvironment;
import static java.util.Optional.of;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class CreateAuthorResolverTests {
    private static AuthorService authorService;
    private static CreateAuthorResolver resolver;

    @Before //needed to reset previous calls so that the error message does show the actual calls only
    public void initMocks() {
        authorService = mock(AuthorService.class);
        resolver = new CreateAuthorResolver(authorService);
    }

    private final Map<String, Object> argumentsProvider;
    private final CreateAuthorDto dto;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {Map.of("firstName", "aaa", "lastName", "bbb"), dto("aaa", "bbb")},
                {Map.of("firstName", "aaa", "lastName", "bbb", "firstName1", "aaa"), dto("aaa", "bbb")},
                {Map.of("lastName", "aaa", "firstName", "bbb"), dto("bbb", "aaa")},
        });
    }

    @Test
    @SneakyThrows
    public void testArgsHandler() {
        DataFetchingEnvironment environment = argumentEnvironment(argumentsProvider);
        resolver.dataFetcher().get(environment);
        verify(authorService).createAuthor(dto);
    }
}
