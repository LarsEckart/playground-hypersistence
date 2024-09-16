package com.larseckart.playgroundhypersistence;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

interface EventRepository extends JpaRepository<Event, Long> {

  List<Event> findByEventName(String eventName);

  /**
   * Causes one select to find all events but then does a delete for each event. :D
   * When we add the nativeQuery, it works as expected.
   */
  @Modifying
  @Transactional
  // @Query(nativeQuery = true, value = "DELETE FROM EVENT WHERE created_time<?1")
  void deleteAllByCreatedTimeBefore(LocalDateTime dateTime);

}
