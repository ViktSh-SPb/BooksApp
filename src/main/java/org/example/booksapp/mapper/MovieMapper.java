package org.example.booksapp.mapper;

import org.example.booksapp.dto.AddMovieRequestDto;
import org.example.booksapp.dto.MovieResponseDto;
import org.example.booksapp.repository.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface MovieMapper {

    @Mapping(source = "director.id", target = "directorId")
    @Mapping(source = "director.name", target = "directorName")
    @Mapping(source = "director.country", target = "directorCountry")
    @Mapping(target = "lastViewDate", expression = "java(getLastViewDate(movie))")
    @Mapping(target = "avgRating", expression = "java(getAvgRating(movie))")
    @Mapping(target = "genres", expression = "java(getGenreNames(movie))")
    MovieResponseDto toDto(Movie movie);

    @Mapping(target = "director", source = "directorId")
    Movie requestDtoToEntity(AddMovieRequestDto addMovieRequestDto);

    default LocalDate getLastViewDate(Movie movie) {
        if (movie.getViews() == null) return null;
        return movie.getViews().stream()
                .map(MovieView::getId)
                .map(MovieViewId::getViewDate)
                .max(LocalDate::compareTo)
                .orElse(null);
    }

    default Double getAvgRating(Movie movie) {
        if (movie.getViews() == null) return null;
        return movie.getViews().stream()
                .filter(v -> v.getRating() != null)
                .mapToDouble(MovieView::getRating)
                .average()
                .orElse(0.0);
    }

    default Set<String> getGenreNames(Movie movie) {
        if (movie.getGenres() == null) return null;
        return movie.getGenres().stream()
                .map(Genre::getName)
                .collect(Collectors.toSet());
    }

    default Director map(Integer id) {
        if (id == null) return null;
        Director director = new Director();
        director.setId(id);
        return director;
    }
}