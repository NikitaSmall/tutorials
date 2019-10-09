package com.graphqljava.tutorial.bookdetails.startup;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.entity.Book;
import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMapper;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class Test {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GraphQLMapper graphQLMapper;

    //@EventListener(ApplicationReadyEvent.class)
    public void go() {
        List<Book> books = bookRepository.findAll();
        List<Author> authors = authorRepository.findAll();
        log.info("Books {}", books);
        log.info("Authors {}", authors);

        List<Map<String, String>> booksMap = graphQLMapper.toGraphQLMap(books);
        List<Map<String, String>> authorsMap = graphQLMapper.toGraphQLMap(authors);
        log.info("Book map {}", books);
        log.info("Authors map {}", authors);
    }
}
