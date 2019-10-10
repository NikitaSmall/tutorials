package com.graphqljava.tutorial.bookdetails.dto.service.author;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    public Author toEntity(CreateAuthorDto dto) {
        return MAPPER.map(dto, Author.class);
    }
}
