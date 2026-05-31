package org.example.booksapp.debug;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.booksapp.dto.BookResponseDto;
import org.example.booksapp.service.BooksService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для диагностики DataSource.
 */
@RestController
@RequestMapping("/debug")
@Profile("dev")
@RequiredArgsConstructor
public class DataSourceDebugController {

    private final BooksService booksService;

    /**
     * Эмулирует медленный HTTP-запрос.
     *
     * @return строка "ok" после задержки в 15 секунд
     * @throws InterruptedException если поток был прерван во время ожидания
     */
    @GetMapping("/slow")
    public ResponseEntity<List<BookResponseDto>> slow() throws Exception {
        System.out.println("START " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        List<BookResponseDto> books = booksService.getAllBooks();
        Thread.sleep(5000);
        System.out.println("END " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        return ResponseEntity.ok(books);
    }
}
