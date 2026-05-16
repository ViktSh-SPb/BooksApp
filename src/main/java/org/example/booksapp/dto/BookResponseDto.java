package org.example.booksapp.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BookResponseDto(
        Integer id,
        String title,
        String author,
        Integer pageCount,
        Boolean available,
        String storageLocation,
        Boolean beenRead,
        LocalDate readDate,
        Double rating,
        Integer priority
) {
}
