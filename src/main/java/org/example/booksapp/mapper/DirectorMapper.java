package org.example.booksapp.mapper;

import org.example.booksapp.dto.AddDirectorRequestDto;
import org.example.booksapp.dto.DirectorResponseDto;
import org.example.booksapp.repository.entity.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    Director requestDtoToEntity(AddDirectorRequestDto dto);
    DirectorResponseDto entityToDto (Director entity);
}
