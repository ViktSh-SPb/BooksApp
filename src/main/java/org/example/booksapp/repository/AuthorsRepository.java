package org.example.booksapp.repository;

import org.example.booksapp.repository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
