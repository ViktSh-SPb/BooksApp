package org.example.booksapp.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
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

    @Column(name = "cover_image")
    private String coverImage;

    @Column
    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<BookRead> bookReads;
}
