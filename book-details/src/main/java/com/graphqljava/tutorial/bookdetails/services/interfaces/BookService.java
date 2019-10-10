package com.graphqljava.tutorial.bookdetails.services.interfaces;

import com.graphqljava.tutorial.bookdetails.entity.Book;

import java.util.List;

public interface BookService {
    Book findById(int id);
    List<Book> findByPageCount(int pageCount);
}
