package org.example.booksapp.debug;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("dev")
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("org.postgresql.Driver");
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;
//    }
}
