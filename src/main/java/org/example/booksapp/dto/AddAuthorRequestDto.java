package org.example.booksapp.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AddAuthorRequestDto(
        String name,
        LocalDate birthDate,
        String country
) {
}
