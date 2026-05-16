package org.example.booksapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.*;
import org.example.booksapp.mapper.BookMapper;
import org.example.booksapp.mapper.BookReadMapper;
import org.example.booksapp.repository.BookReadRepository;
import org.example.booksapp.repository.BookRepository;
import org.example.booksapp.repository.entity.Author;
import org.example.booksapp.repository.entity.Book;
import org.example.booksapp.repository.entity.BookRead;
import org.example.booksapp.repository.projection.BookWithInfo;
import org.example.booksapp.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookReadRepository bookReadRepository;
    private final BookReadMapper bookReadMapper;

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAllWithInfo().stream()
                .map(bookMapper::projectionToDto)
                .toList();
    }

    @Override
    public BookResponseDto getBookById(Integer id) {
        BookWithInfo bookWithInfo = bookRepository.findByIdWithInfo(id).orElseThrow();
        return bookMapper.projectionToDto(bookWithInfo);
    }

    @Override
    public BookResponseDto addBook(AddBookRequestDto requestDto) {
        Book newBook = bookRepository.save(bookMapper.addRequestDtoToEntity(requestDto));
        BookWithInfo bookWithInfo = bookRepository.findByIdWithInfo(newBook.getId()).orElseThrow();
        return bookMapper.projectionToDto(bookWithInfo);
    }

    @Override
    public BookResponseDto readBook(ReadBookRequestDto requestDto) {
        BookRead newRead = bookReadRepository.save(bookReadMapper.requestDtoToEntity(requestDto));
        BookWithInfo book = bookRepository.findByIdWithInfo(newRead.getBookId()).orElseThrow();
        return bookMapper.projectionToDto(book);
    }

    @Override
    public BookResponseDto updateBook(UpdateBookRequestDto requestDto) {
        BookWithInfo book = bookRepository.findByIdWithInfo(requestDto.id())
            .orElseThrow(() -> new RuntimeException("Book not found"));
        return bookMapper.projectionToDto(book);
    }
}
