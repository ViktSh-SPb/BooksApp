package org.example.booksapp.repository;

import org.example.booksapp.repository.entity.MovieView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieViewRepository extends JpaRepository<MovieView, Integer> {
}
