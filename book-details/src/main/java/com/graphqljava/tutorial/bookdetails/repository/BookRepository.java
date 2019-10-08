package com.graphqljava.tutorial.bookdetails.repository;

import com.graphqljava.tutorial.bookdetails.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
