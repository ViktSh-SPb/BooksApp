package org.example.booksapp.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AuthorResponseDto(
        Integer id,
        String name,
        LocalDate birthDate,
        String country
) {
}
