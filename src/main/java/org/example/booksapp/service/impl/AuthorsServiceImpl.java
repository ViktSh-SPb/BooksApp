package org.example.booksapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.AddAuthorRequestDto;
import org.example.booksapp.dto.AuthorResponseDto;
import org.example.booksapp.mapper.AuthorMapper;
import org.example.booksapp.repository.AuthorsRepository;
import org.example.booksapp.repository.entity.Author;
import org.example.booksapp.service.AuthorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepository authorsRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        return authorsRepository.findAll().stream()
                .map(authorMapper::entityToDto)
                .toList();
    }

    @Override
    public AuthorResponseDto addAuthor(AddAuthorRequestDto request) {
        Author newAuthor = authorsRepository.save(authorMapper.requestDtoToEntity(request));
        return authorMapper.entityToDto(newAuthor);
    }

    @Override
    public AuthorResponseDto getAuthorById(Integer id) {
        Author author = authorsRepository.findById(id).orElseThrow();
        return authorMapper.entityToDto(author);
    }
}
