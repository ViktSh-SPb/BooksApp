package org.example.booksapp.repository;

import org.example.booksapp.repository.entity.BookRead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReadRepository extends JpaRepository<BookRead, Integer> {
}
