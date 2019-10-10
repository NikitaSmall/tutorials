package com.graphqljava.tutorial.bookdetails.dto.service.author;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorDto.dto;
import static com.graphqljava.tutorial.bookdetails.entity.Author.author;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class CreateAuthorMapperTests {
    private static final CreateAuthorMapper mapper = new CreateAuthorMapper();

    private final CreateAuthorDto createAuthorDto;
    private final Author author;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {dto("aaa", "bbb"), author("aaa", "bbb")},
                {dto("ccc", "ccc"), author("ccc", "ccc")},
                {dto("1", "ccc"), author("1", "ccc")},
        });
    }

    @Test
    public void testMapping() {
        assertEquals(author, mapper.toEntity(createAuthorDto));
    }
}
