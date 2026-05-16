package org.example.booksapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.AddDirectorRequestDto;
import org.example.booksapp.dto.DirectorResponseDto;
import org.example.booksapp.service.DirectorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directors")
@CrossOrigin(origins = "http://localhost:5173")
public class DirectorsController {

    private final DirectorsService directorsService;

    @GetMapping
    public ResponseEntity<List<DirectorResponseDto>> getAllDirectors() {
        List<DirectorResponseDto> directorsList = directorsService.getAllDirectors();
        return ResponseEntity.ok(directorsList);
    }

    @GetMapping("/{directorId}")
    public ResponseEntity<DirectorResponseDto> getDirectorById(@PathVariable Integer directorId){
        return ResponseEntity.ok(directorsService.getDirectorById(directorId));
    }

    @PostMapping
    public ResponseEntity<DirectorResponseDto> addDirector(@RequestBody @Valid AddDirectorRequestDto requestDto) {
        DirectorResponseDto newDirector = directorsService.addDirector(requestDto);
        return ResponseEntity.ok(newDirector);
    }
}
