package de.hundertneun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static final LocalDateTime CURRENT_DATE_TIME = LocalDateTime.of(2016, 6, 6, 0, 0);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
