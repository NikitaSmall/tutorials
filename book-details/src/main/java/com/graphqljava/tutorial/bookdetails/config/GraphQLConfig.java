package com.graphqljava.tutorial.bookdetails.config;

import com.graphqljava.tutorial.bookdetails.GraphQLDataFetchers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.graphqljava.tutorial.bookdetails.utility.ResourceUtility.stringResource;
import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class GraphQLConfig {
    private static final SchemaGenerator SCHEMA_GENERATOR = new SchemaGenerator();
    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    public GraphQL graphQL() {
        GraphQLSchema graphQLSchema = buildSchema(stringResource("schema.graphqls"));
        return newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        return SCHEMA_GENERATOR.makeExecutableSchema(
                new SchemaParser().parse(sdl),
                buildWiring()
        );
    }

    //TODO: should possibly be separated and moved to other classes
    private RuntimeWiring buildWiring() {
        return newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                .type(newTypeWiring("Book")
                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                .build();
    }


}
