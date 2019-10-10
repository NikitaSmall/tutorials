package com.graphqljava.tutorial.bookdetails.integration;

import com.graphqljava.tutorial.bookdetails.controller.CustomGraphQLController;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

import static com.graphqljava.tutorial.bookdetails.entity.Author.author;
import static com.graphqljava.tutorial.bookdetails.entity.Book.book;
import static com.graphqljava.tutorial.bookdetails.mocks.repository.BookRepositoryMocks.mockBookIdQuery;
import static com.graphqljava.tutorial.bookdetails.utility.ResourceUtility.stringResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookByIdTest {
    @Autowired
    private CustomGraphQLController controller;

    @MockBean
    private BookRepository bookRepository;

    @Before
    public void initRepo() {
        mockBookIdQuery(bookRepository, 1, book(1, "name", 1000, author("aaa", "bbb")));
        mockBookIdQuery(bookRepository, 2, null);
    }

    @Test
    @SneakyThrows
    public void testQuerySuccess() {
        String query = stringResource("queries/bookByIdQuery1.txt");
        CompletableFuture bookFuture = (CompletableFuture) controller.simpleGraphqlPOST(query, null);
        Assert.assertEquals(stringResource("responses/bookByIdQuery1.txt"), bookFuture.get().toString());
    }

    @Test
    @SneakyThrows
    public void testQueryEmpty() {
        String query = stringResource("queries/bookByIdQuery2.txt");
        CompletableFuture bookFuture = (CompletableFuture) controller.simpleGraphqlPOST(query, null);
        Assert.assertEquals(stringResource("responses/bookByIdQuery2.txt"), bookFuture.get().toString());
    }
}
