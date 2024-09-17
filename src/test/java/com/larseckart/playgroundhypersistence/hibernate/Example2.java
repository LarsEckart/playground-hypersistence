package com.larseckart.playgroundhypersistence.hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class Example2 {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> database =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("test")
                    .withUsername("duke")
                    .withPassword("s3cret");

    @Autowired
    EventRepository repository;

    @Test
    void causes_n_deletes_instead_of_one() {
        LocalDate now = LocalDate.now();

        var days = IntStream.iterate(0, i -> i + 1)
            .limit(10)
            .mapToObj(i -> new Event("any", now.minusDays(i).atStartOfDay()))
            .toList();

        repository.saveAll(days);

        repository.deleteAllByCreatedTimeBefore(LocalDateTime.now());
    }

}
