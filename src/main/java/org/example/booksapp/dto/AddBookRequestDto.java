package org.example.booksapp.dto;

import lombok.Builder;

@Builder
public record AddBookRequestDto(
        String title,
        Integer pageCount,
        Boolean available,
        String storageLocation,
        String cover,
        Integer authorId
) {
}