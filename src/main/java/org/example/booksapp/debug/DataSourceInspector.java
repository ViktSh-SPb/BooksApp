package org.example.booksapp.debug;

import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataSourceInspector {

    private final DataSource dataSource;


    public DataSourceInspector(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void showDataSource() {
        System.out.println("Current DataSource class: " + dataSource.getClass());
    }
}
