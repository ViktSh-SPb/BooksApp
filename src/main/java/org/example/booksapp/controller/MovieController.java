package org.example.booksapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.*;
import org.example.booksapp.service.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {
    private final MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        List<MovieResponseDto> movies = moviesService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable Integer movieId) {
        return ResponseEntity.ok(moviesService.getMovieById(movieId));
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody @Valid AddMovieRequestDto requestDto) {
        MovieResponseDto newMovie = moviesService.addMovie(requestDto);
        return ResponseEntity.ok(newMovie);
    }

    @PostMapping("/view")
    public ResponseEntity<MovieResponseDto> viewMovie(@RequestBody @Valid WatchMovieRequestDto requestDto) {
        MovieResponseDto newMovie = moviesService.viewMovie(requestDto);
        return ResponseEntity.ok(newMovie);
    }
}