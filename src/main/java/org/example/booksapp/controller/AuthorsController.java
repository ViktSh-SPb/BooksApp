package org.example.booksapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.AddAuthorRequestDto;
import org.example.booksapp.dto.AuthorResponseDto;
import org.example.booksapp.service.AuthorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthorsController {

    private final AuthorsService authorsService;

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        List<AuthorResponseDto> authorsList = authorsService.getAllAuthors();
        return ResponseEntity.ok(authorsList);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Integer authorId){
        return ResponseEntity.ok(authorsService.getAuthorById(authorId));
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody @Valid AddAuthorRequestDto requestDto) {
        AuthorResponseDto newAuthor = authorsService.addAuthor(requestDto);
        return ResponseEntity.ok(newAuthor);
    }
}
