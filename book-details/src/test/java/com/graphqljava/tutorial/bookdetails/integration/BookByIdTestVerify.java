package com.graphqljava.tutorial.bookdetails.integration;

import com.graphqljava.tutorial.bookdetails.controller.CustomGraphQLController;
import com.graphqljava.tutorial.bookdetails.repository.BookRepository;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.graphqljava.tutorial.bookdetails.utility.ResourceUtility.stringResource;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookByIdTestVerify {
    @Autowired
    private CustomGraphQLController controller;

    @MockBean
    private BookRepository bookRepository;

    @Test
    @SneakyThrows
    public void testQuerySuccess() {
        controller.simpleGraphqlPOST(stringResource("queries/bookByIdQuery1.txt"), null);
        verify(bookRepository).findById(1);
    }

    @Test
    @SneakyThrows
    public void testQueryEmpty() {
        controller.simpleGraphqlPOST(stringResource("queries/bookByIdQuery2.txt"), null);
        verify(bookRepository).findById(2);
    }
}
