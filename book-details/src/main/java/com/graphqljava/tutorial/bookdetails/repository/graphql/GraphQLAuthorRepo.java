package com.graphqljava.tutorial.bookdetails.repository.graphql;

import com.graphqljava.tutorial.bookdetails.graphql.mappings.GraphQLMapper;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GraphQLAuthorRepo {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GraphQLMapper graphQLMapper;

    public List<Map<String, String>> findAll() {
        return graphQLMapper.toGraphQLMap(authorRepository.findAll());
    }
}
