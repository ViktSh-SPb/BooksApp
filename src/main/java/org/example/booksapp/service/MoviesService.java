package org.example.booksapp.service;

import org.example.booksapp.dto.AddMovieRequestDto;
import org.example.booksapp.dto.MovieResponseDto;
import org.example.booksapp.dto.WatchMovieRequestDto;

import java.util.List;

public interface MoviesService {
    List<MovieResponseDto> getAllMovies();
    MovieResponseDto getMovieById(Integer id);
    MovieResponseDto addMovie(AddMovieRequestDto dto);
    MovieResponseDto viewMovie(WatchMovieRequestDto dto);
}
