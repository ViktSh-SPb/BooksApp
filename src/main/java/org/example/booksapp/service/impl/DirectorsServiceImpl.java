package org.example.booksapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.AddDirectorRequestDto;
import org.example.booksapp.dto.DirectorResponseDto;
import org.example.booksapp.mapper.DirectorMapper;
import org.example.booksapp.repository.DirectorRepository;
import org.example.booksapp.repository.entity.Director;
import org.example.booksapp.service.DirectorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorsServiceImpl implements DirectorsService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public List<DirectorResponseDto> getAllDirectors() {
        return directorRepository.findAll().stream()
                .map(directorMapper::entityToDto)
                .toList();
    }

    @Override
    public DirectorResponseDto addDirector(AddDirectorRequestDto request) {
        Director newDirector = directorRepository.save(directorMapper.requestDtoToEntity(request));
        return directorMapper.entityToDto(newDirector);
    }

    @Override
    public DirectorResponseDto getDirectorById(Integer id) {
        Director director = directorRepository.findById(id).orElseThrow();
        return directorMapper.entityToDto(director);
    }
}
