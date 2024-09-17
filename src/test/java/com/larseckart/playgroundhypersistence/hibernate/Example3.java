package com.larseckart.playgroundhypersistence.hibernate;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class Example3 {

  @Container
  @ServiceConnection
  static PostgreSQLContainer<?> database =
      new PostgreSQLContainer<>("postgres:latest")
          .withDatabaseName("test")
          .withUsername("duke")
          .withPassword("s3cret");

  @Autowired
  EventService eventService;

  @Test
  void deletes_dont_happen_before_the_insert_thus_violating_unique_constraint() {
    eventService.save(new Event("Independence Day", LocalDate.of(2025, 8, 20).atStartOfDay()));
    //tx.commit - from service-layer

    var eventList = List.of(
        new Event("Independence Day", LocalDate.of(2025, 8, 20).atStartOfDay()),
        new Event("Midsummer", LocalDate.of(2025, 6, 23).atStartOfDay())
    );
    eventService.replaceALl( eventList);
  }

  /*
  What you can do to have fun with this:
  - remove @Transactional from service-layer and see how the delete now happens before the insert
  - add another Event and you will see that it deletes 2 by ID instead of 1 delete command for all
   */

}
