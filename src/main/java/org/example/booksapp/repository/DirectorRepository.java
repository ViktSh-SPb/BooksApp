package org.example.booksapp.repository;

import org.example.booksapp.repository.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
