package org.example.booksapp.repository.projection;

import java.time.LocalDate;

public interface BookWithInfo {
    Integer getId();
    String getTitle();
    String getAuthor();
    Integer getPageCount();
    Boolean getAvailable();
    String getStorageLocation();
    Boolean getBeenRead();
    LocalDate getReadDate();
    Double getRating();
    Integer getPriority();
}