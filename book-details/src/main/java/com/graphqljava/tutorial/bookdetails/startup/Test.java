package com.graphqljava.tutorial.bookdetails.startup;

import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Test {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void go() {
        log.info("Books {}", bookRepository.findAll());
        log.info("Authors {}", authorRepository.findAll());
    }
}
