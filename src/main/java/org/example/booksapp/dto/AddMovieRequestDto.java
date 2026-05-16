package org.example.booksapp.dto;

public record AddMovieRequestDto(
        String title,
        Integer releaseYear,
        String country,
        String poster,
        Integer directorId
) {
}
