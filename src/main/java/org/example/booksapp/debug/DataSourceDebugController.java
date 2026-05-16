package org.example.booksapp.debug;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для диагностики DataSource.
 */
@RestController
@RequestMapping("/debug")
@Profile("dev")
public class DataSourceDebugController {

    /**
     * Эмулирует медленный HTTP-запрос.
     *
     * @return строка "ok" после задержки в 15 секунд
     * @throws InterruptedException если поток был прерван во время ожидания
     */
    @GetMapping("/slow")
    public String slow() throws Exception {
        System.out.println("START " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        Thread.sleep(15000);
        System.out.println("END " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        return "ok";
    }
}
