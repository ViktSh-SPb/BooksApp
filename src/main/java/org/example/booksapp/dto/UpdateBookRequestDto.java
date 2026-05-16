package org.example.booksapp.dto;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record UpdateBookRequestDto(
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
