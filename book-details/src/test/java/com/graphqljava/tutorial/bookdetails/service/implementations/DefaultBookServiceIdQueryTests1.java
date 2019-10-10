package com.graphqljava.tutorial.bookdetails.service.implementations;


import com.graphqljava.tutorial.bookdetails.entity.Book;
import com.graphqljava.tutorial.bookdetails.services.implementations.DefaultBookService;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static com.graphqljava.tutorial.bookdetails.entity.Book.noAuthorBook;
import static com.graphqljava.tutorial.bookdetails.mocks.repository.BookRepositoryMocks.mockIdRepository;
import static java.util.Optional.of;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class DefaultBookServiceIdQueryTests1 {
    private static DefaultBookService service;

    private final Map<Integer, Optional<Book>> repoMockProvider;
    private final int id;
    private final Book expectedResult;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {Map.of(1, Optional.empty()), 1, null},
                {Map.of(1, Optional.empty(), 2, of(noAuthorBook("aa", 10))), 1, null},
                {Map.of(1, Optional.empty(), 2, of(noAuthorBook("aa", 10))), 2, noAuthorBook("aa", 10)},
        });
    }

    @Test
    public void testIdQuery() {
        service = new DefaultBookService(mockIdRepository(repoMockProvider));
        Assert.assertEquals(expectedResult, service.findById(id));
    }
}
