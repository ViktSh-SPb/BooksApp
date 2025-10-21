package org.example.booksapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column
    private Boolean available = false;

    @Column(name = "storage_location")
    private String storageLocation;

    @Column(name = "is_read")
    private Boolean isRead = false;

    @Column(name = "read_date")
    private LocalDate readDate;

    @Column(name = "cover_image")
    private String coverImage;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
