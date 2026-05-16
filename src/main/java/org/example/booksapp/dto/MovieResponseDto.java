package org.example.booksapp.dto;

import java.time.LocalDate;
import java.util.Set;

public record MovieResponseDto(
        Integer id,
        String title,
        Integer releaseYear,
        String country,
        String poster,
        Integer directorId,
        String directorName,
        String directorCountry,
        LocalDate lastViewDate,
        Double avgRating,
        Set<String> genres
) {
}