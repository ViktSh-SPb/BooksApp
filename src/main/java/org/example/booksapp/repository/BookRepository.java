package org.example.booksapp.repository;

import org.example.booksapp.repository.entity.Book;
import org.example.booksapp.repository.projection.BookWithInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = """
        SELECT
            b.id AS id,
            b.title AS title,
            a.name AS author,
            b.pageCount AS pageCount,
            b.available AS available,
            b.storageLocation AS storageLocation,
            CASE WHEN EXISTS (
                SELECT 1
                FROM BookRead br2
                WHERE br2.bookId = b.id
            ) THEN true ELSE false END AS beenRead,
            MAX(br.readDate) AS readDate,
            AVG(br.rating) AS rating,
            b.priority AS priority
        FROM Book b
        LEFT JOIN b.author a
        LEFT JOIN BookRead br ON br.bookId = b.id
        GROUP BY b.id, b.title, a.name, b.pageCount, b.available, b.storageLocation, b.priority
    """)
    List<BookWithInfo> findAllWithInfo();


    @Query(value = """
        SELECT
            b.id AS id,
            b.title AS title,
            a.name AS author,
            b.pageCount AS pageCount,
            b.available AS available,
            b.storageLocation AS storageLocation,
            CASE WHEN EXISTS (
                SELECT 1
                FROM BookRead br2
                WHERE br2.bookId = b.id
            ) THEN true ELSE false END AS beenRead,
            MAX(br.readDate) AS readDate,
            AVG(br.rating) AS rating,
            b.priority AS priority
        FROM Book b
        LEFT JOIN b.author a
        LEFT JOIN BookRead br ON br.bookId = b.id
        WHERE b.id = :id
        GROUP BY b.id, b.title, a.name, b.pageCount, b.available, b.storageLocation, b.priority
    """)
    Optional<BookWithInfo> findByIdWithInfo(@Param("id") Integer id);
}
