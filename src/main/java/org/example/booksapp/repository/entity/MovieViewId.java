package org.example.booksapp.repository.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MovieViewId implements Serializable {

    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "view_date", nullable = false)
    private LocalDate viewDate;
}
