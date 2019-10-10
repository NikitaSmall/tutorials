package com.graphqljava.tutorial.bookdetails.services.implementations;

import com.graphqljava.tutorial.bookdetails.entity.Book;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import com.graphqljava.tutorial.bookdetails.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookService implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findByPageCount(int pageCount) {
        return bookRepository.findByPageCount(pageCount);
    }
}
