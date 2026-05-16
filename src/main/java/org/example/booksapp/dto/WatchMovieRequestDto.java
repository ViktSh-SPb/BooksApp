package org.example.booksapp.dto;

import java.time.LocalDate;

public record WatchMovieRequestDto(
        Integer movieId,
        LocalDate viewDate,
        Integer rating
) {
}
