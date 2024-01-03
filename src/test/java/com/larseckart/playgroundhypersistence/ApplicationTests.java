package com.larseckart.playgroundhypersistence;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class ApplicationTests {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> database =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("test")
                    .withUsername("duke")
                    .withPassword("s3cret");

    @Test
    void contextLoads() {
    }

}
