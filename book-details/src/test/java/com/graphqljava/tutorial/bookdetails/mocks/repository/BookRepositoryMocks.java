package com.graphqljava.tutorial.bookdetails.mocks.repository;

import com.graphqljava.tutorial.bookdetails.entity.Book;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;

import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookRepositoryMocks {
    public static BookRepository mockIdRepository(Map<Integer, Optional<Book>> provider) {
        BookRepository bookRepository = mock(BookRepository.class);
        provider.forEach((k, v) -> when(bookRepository.findById(k)).thenReturn(v));
        return bookRepository;
    }
}
