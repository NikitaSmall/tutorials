package com.graphqljava.tutorial.bookdetails.service.implementations;

import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import com.graphqljava.tutorial.bookdetails.services.implementations.DefaultBookService;
import com.graphqljava.tutorial.bookdetails.services.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class DefaultBookServiceIdQueryTests2 {
    private static BookRepository repository;
    private static BookService service;

    @Before //needed to reset previous calls so that the error message does show the actual calls only
    public void initMocks() {
        repository = mock(BookRepository.class);
        service = new DefaultBookService(repository);
    }

    private final int id;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {1},
                {23},
                {34},
        });
    }

    @Test
    public void testIdQuery() {
        service.findById(id);
        verify(repository).findById(id);
    }
}
