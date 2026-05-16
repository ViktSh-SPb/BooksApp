package org.example.booksapp.mapper;

import org.example.booksapp.dto.AddAuthorRequestDto;
import org.example.booksapp.dto.AuthorResponseDto;
import org.example.booksapp.repository.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author requestDtoToEntity(AddAuthorRequestDto dto);
    AuthorResponseDto entityToDto (Author entity);
}
