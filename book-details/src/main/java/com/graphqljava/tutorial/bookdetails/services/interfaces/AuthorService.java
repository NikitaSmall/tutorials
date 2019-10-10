package com.graphqljava.tutorial.bookdetails.services.interfaces;

import com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorDto;
import com.graphqljava.tutorial.bookdetails.entity.Author;

public interface AuthorService {
    Author createAuthor(CreateAuthorDto dto);
}
