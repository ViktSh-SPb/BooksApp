package org.example.booksapp.service.impl;

import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.*;
import org.example.booksapp.mapper.MovieMapper;
import org.example.booksapp.mapper.MovieViewMapper;
import org.example.booksapp.repository.DirectorRepository;
import org.example.booksapp.repository.MovieRepository;
import org.example.booksapp.repository.MovieViewRepository;
import org.example.booksapp.repository.entity.BookRead;
import org.example.booksapp.repository.entity.Director;
import org.example.booksapp.repository.entity.Movie;
import org.example.booksapp.repository.entity.MovieView;
import org.example.booksapp.repository.projection.BookWithInfo;
import org.example.booksapp.service.MoviesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final DirectorRepository directorRepository;
    private final MovieViewRepository movieViewRepository;
    private final MovieViewMapper movieViewMapper;

    @Override
    public List<MovieResponseDto> getAllMovies() {
        return movieRepository.findAllWithInfo().stream()
            .map(movieMapper::toDto)
            .sorted(Comparator.comparing(MovieResponseDto::id))
            .toList();
    }

    @Override
    public MovieResponseDto getMovieById(Integer id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieResponseDto addMovie(AddMovieRequestDto request) {
        Director director = directorRepository.findById(request.directorId())
                .orElseThrow(() -> new RuntimeException("Director not found"));

        Movie movie = movieMapper.requestDtoToEntity(request);
        movie.setDirector(director);

        Movie newMovie = movieRepository.save(movie);
        return movieMapper.toDto(newMovie);
    }

    @Override
    public MovieResponseDto viewMovie(WatchMovieRequestDto dto) {
        MovieView newView = movieViewRepository.save(movieViewMapper.requestDtotoEntity(dto));
        Movie movie = movieRepository.findById(newView.getId().getMovieId()).orElseThrow();
        return movieMapper.toDto(movie);
    }
}
