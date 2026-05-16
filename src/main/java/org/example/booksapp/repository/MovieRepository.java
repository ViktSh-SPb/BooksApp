package org.example.booksapp.repository;

import org.example.booksapp.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("""
    SELECT DISTINCT m
    FROM Movie m
    LEFT JOIN FETCH m.director
    LEFT JOIN FETCH m.genres
    LEFT JOIN FETCH m.views
""")
    List<Movie> findAllWithInfo();
}


