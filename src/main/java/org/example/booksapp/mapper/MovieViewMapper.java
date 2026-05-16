package org.example.booksapp.mapper;

import org.example.booksapp.dto.WatchMovieRequestDto;
import org.example.booksapp.repository.entity.MovieView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MovieViewMapper {
    @Mappings({
            @Mapping(target = "id.movieId", source = "movieId"),
            @Mapping(target = "id.viewDate", source = "viewDate"),
            @Mapping(target = "rating", source = "rating")
    })
    MovieView requestDtotoEntity(WatchMovieRequestDto dto);
}
