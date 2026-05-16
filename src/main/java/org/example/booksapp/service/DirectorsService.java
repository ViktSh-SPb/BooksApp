package org.example.booksapp.service;

import org.example.booksapp.dto.AddDirectorRequestDto;
import org.example.booksapp.dto.DirectorResponseDto;

import java.util.List;

public interface DirectorsService {
    List<DirectorResponseDto> getAllDirectors();
    DirectorResponseDto getDirectorById(Integer id);
    DirectorResponseDto addDirector(AddDirectorRequestDto dto);
}
