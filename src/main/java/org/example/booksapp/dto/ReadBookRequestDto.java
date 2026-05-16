package org.example.booksapp.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReadBookRequestDto(
        Integer bookId,
        LocalDate readDate,
        Integer rating
) {
}
