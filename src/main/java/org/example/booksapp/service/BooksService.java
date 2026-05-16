package org.example.booksapp.service;

import org.example.booksapp.dto.AddBookRequestDto;
import org.example.booksapp.dto.BookResponseDto;
import org.example.booksapp.dto.ReadBookRequestDto;

import java.util.List;
import org.example.booksapp.dto.UpdateBookRequestDto;

public interface BooksService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Integer id);
    BookResponseDto addBook(AddBookRequestDto requestDto);
    BookResponseDto readBook(ReadBookRequestDto requestDto);
    BookResponseDto updateBook(UpdateBookRequestDto requestDto);
}
