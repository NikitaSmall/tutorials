package com.graphqljava.tutorial.bookdetails.repository.graphql;

import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMapper;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GraphQLBookRepo {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GraphQLMapper graphQLMapper;

    public List<Map<String, String>> findAll() {
        return graphQLMapper.toGraphQLMap(bookRepository.findAll());
    }
}
