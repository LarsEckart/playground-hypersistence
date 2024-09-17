package com.larseckart.playgroundhypersistence.hibernate;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface EventRepository extends JpaRepository<Event, Long> {

  List<Event> findByEventName(String eventName);

  /**
   * Causes one select to find all events but then does a delete for each event. :D
   * When we add the nativeQuery, it works as expected.
   */
  @Modifying
  // @Query(nativeQuery = true, value = "DELETE FROM EVENT WHERE created_time<?1")
  void deleteAllByCreatedTimeBefore(LocalDateTime dateTime);

  /**
   * DELETE is (and isn't) what you expect
   * * initially a SELECT, eventually a DELETE

   * * A JPA provider is allowed to delay operations on the database
   *   to potentially batch those up to potentially gain performance benefits.
   *   <a href="https://github.com/spring-projects/spring-data-jpa/issues/1100">...</a>
   *   Hibernate executes them in a special way (so foreign-key constraints cannot be violated)
   *     Inserts, in the order they were performed
   *     Updates
   *     Deletion of collection elements
   *     Insertion of collection elements
   *     Deletes, in the order they were performed
   *  * using a custom-query by-passes this logic (and executes it in the order it is defined in code)
   */
  @Modifying
  // @Query(nativeQuery = true, value = "DELETE FROM event")
  void deleteAll();

}
