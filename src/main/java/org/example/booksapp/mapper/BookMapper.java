package org.example.booksapp.mapper;

import org.example.booksapp.dto.AddBookRequestDto;
import org.example.booksapp.dto.BookResponseDto;
import org.example.booksapp.repository.entity.Author;
import org.example.booksapp.repository.entity.Book;
import org.example.booksapp.repository.projection.BookWithInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDto projectionToDto(BookWithInfo bookProjection);

    @Mapping(target = "author", source = "authorId")
    Book addRequestDtoToEntity(AddBookRequestDto requestDto);

    default Author map(Integer id) {
        if (id == null) return null;
        Author author = new Author();
        author.setId(id);
        return author;
    }
}