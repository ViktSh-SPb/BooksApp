package org.example.booksapp.service;

import org.example.booksapp.dto.AddAuthorRequestDto;
import org.example.booksapp.dto.AuthorResponseDto;

import java.util.List;

public interface AuthorsService {

    List<AuthorResponseDto> getAllAuthors();

    AuthorResponseDto addAuthor(AddAuthorRequestDto request);

    AuthorResponseDto getAuthorById(Integer id);
}
