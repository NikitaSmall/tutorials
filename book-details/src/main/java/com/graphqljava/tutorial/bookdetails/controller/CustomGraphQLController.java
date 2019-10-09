package com.graphqljava.tutorial.bookdetails.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionResult;
import graphql.spring.web.servlet.ExecutionResultHandler;
import graphql.spring.web.servlet.GraphQLInvocation;
import graphql.spring.web.servlet.GraphQLInvocationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class CustomGraphQLController {
    @Autowired
    GraphQLInvocation graphQLInvocation;
    @Autowired
    ExecutionResultHandler executionResultHandler;

    @PostMapping(value = "/custom/graphql", consumes = TEXT_PLAIN_VALUE)
    public Object simpleGraphqlPOST(@RequestBody String body, WebRequest webRequest) {
        CompletableFuture<ExecutionResult> executionResult = graphQLInvocation.invoke(
                new GraphQLInvocationData(body, null, null),
                webRequest
        );
        return executionResultHandler.handleExecutionResult(executionResult);
    }
}
