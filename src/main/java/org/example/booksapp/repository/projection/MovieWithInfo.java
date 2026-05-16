package org.example.booksapp.repository.projection;

import java.time.LocalDate;
import java.util.Set;

public interface MovieWithInfo {
    Integer getId();
    String getTitle();
    Integer getReleaseYear();
    String getCountry();
    String getPoster();
    Integer getDirectorId();
    String getDirectorName();
    String getDirectorCountry();
    LocalDate getLastViewDate();
    Double getAvgRating();
    Set<String> getGenres();
}