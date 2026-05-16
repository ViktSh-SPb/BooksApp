package org.example.booksapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.*;
import org.example.booksapp.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:5173")
public class BooksController {
    private final BooksService booksService;

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> books = booksService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Integer bookId) {
        BookResponseDto book = booksService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody @Valid AddBookRequestDto requestDto) {
        BookResponseDto newBook = booksService.addBook(requestDto);
        return ResponseEntity.ok(newBook);
    }

    @PostMapping("/read")
    public ResponseEntity<BookResponseDto> readBook(@RequestBody @Valid ReadBookRequestDto requestDto) {
        BookResponseDto newBook = booksService.readBook(requestDto);
        return ResponseEntity.ok(newBook);
    }

    @PatchMapping
    public ResponseEntity<BookResponseDto> updateBook(@RequestBody @Valid UpdateBookRequestDto requestDto) {
        BookResponseDto newBook = booksService.updateBook(requestDto);
        return ResponseEntity.ok(newBook);
    }
}
