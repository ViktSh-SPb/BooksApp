package org.example.booksapp.debug;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.sql.DataSource;
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
    private final DataSource dataSource;
    private final List<Connection> leakedConnections = new CopyOnWriteArrayList<>();

    /**
     * Эмулирует медленный HTTP-запрос.
     *
     * @return строка "ok" после задержки в 5 секунд
     * @throws InterruptedException если поток был прерван во время ожидания
     */
    @GetMapping("/slow")
    public ResponseEntity<List<BookResponseDto>> slow() throws Exception {
        System.out.println("START " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        List<BookResponseDto> books = booksService.getAllBooks();
//        Thread.sleep(5000);
        System.out.println("END " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        return ResponseEntity.ok(books);
    }

    /**
     * Эмулирует утечку соединения с базой данных.
     * <p>
     * Получает новое соединение из пула и сохраняет его в памяти,
     * не возвращая обратно в пул. Используется для проверки работы
     * механизма обнаружения утечек соединений (HikariCP leak detection).
     *
     * @return информация о количестве удерживаемых соединений
     * @throws SQLException если не удалось получить соединение из пула
     */
    @GetMapping("/leak")
    public String leak() throws SQLException {
        Connection connection = dataSource.getConnection();
        leakedConnections.add(connection);
        return "Leaked connections: " + leakedConnections.size();
    }

    @GetMapping("/conn")
    public String conn() throws SQLException {
        Connection c = dataSource.getConnection();

        return String.format(
            "hash=%s closed=%s",
            System.identityHashCode(c),
            c.isClosed()
        );
    }
}
