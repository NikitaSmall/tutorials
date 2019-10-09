package com.graphqljava.tutorial.bookdetails.startup;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.entity.Book;
import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMapper;
import com.graphqljava.tutorial.bookdetails.repository.graphql.GraphQLRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
public class Test {
    @Autowired
    private GraphQLRepository graphQLRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void go() {
        log.info("{}", graphQLRepository.findAll(Book.class));
        log.info("{}", graphQLRepository.findAll(Author.class));
    }
}
