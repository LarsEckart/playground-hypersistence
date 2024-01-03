package com.larseckart.playgroundhypersistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

@TestConfiguration(proxyBeanMethods = false)
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.from(Application::main)
                .with(TestApplication.class)
                .run(args);
    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withUsername("postgres")
                .withPassword("postgres");
    }

    @Bean
    public CommandLineRunner demo(AlbumRepository repository, SongRepository songRepository, PostgreSQLContainer container) {
        System.out.println(container.getJdbcUrl());
        return (args) -> {
            Song song = new Song(123L, new Artist("SDP", "Germany", "Pop"));
            songRepository.save(song);

            repository.save(new Album(new CoverArt("any", "any", "any"),
                    List.of(song)));


        };
    }

}
