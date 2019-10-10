package com.graphqljava.tutorial.bookdetails.services.implementations;

import com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorDto;
import com.graphqljava.tutorial.bookdetails.dto.service.author.CreateAuthorMapper;
import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.repository.AuthorRepository;
import com.graphqljava.tutorial.bookdetails.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuthorService implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CreateAuthorMapper createAuthorMapper;

    @Override
    public Author createAuthor(CreateAuthorDto dto) {
        return authorRepository.save(createAuthorMapper.toEntity(dto));
    }
}
