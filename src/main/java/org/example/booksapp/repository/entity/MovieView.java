package org.example.booksapp.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_views")
public class MovieView {

    @EmbeddedId
    private MovieViewId id;

    @Column(name = "rating", precision = 2, scale = 1)
    private Integer rating;
}
