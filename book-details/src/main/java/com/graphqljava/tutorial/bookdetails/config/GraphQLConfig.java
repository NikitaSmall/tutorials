package com.graphqljava.tutorial.bookdetails.config;

import com.graphqljava.tutorial.bookdetails.fetchers.GraphQLFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.graphqljava.tutorial.bookdetails.utility.ResourceUtility.stringResource;
import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class GraphQLConfig {
    private static final SchemaGenerator SCHEMA_GENERATOR = new SchemaGenerator();
    @Autowired
    private List<GraphQLFetcher> graphQLFetchers;

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

    private RuntimeWiring buildWiring() {
        RuntimeWiring.Builder wiring = newRuntimeWiring();
        for (GraphQLFetcher fetcher : graphQLFetchers) {
            wiring = wiring
                    .type(newTypeWiring(fetcher.typeName())
                            .dataFetcher(fetcher.fieldName(), fetcher.dataFetcher()));
        }
        return wiring.build();
    }
}
