package org.example.booksapp.mapper;

import org.example.booksapp.dto.ReadBookRequestDto;
import org.example.booksapp.repository.entity.BookRead;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface BookReadMapper {

    BookRead requestDtoToEntity(ReadBookRequestDto dto);

}
