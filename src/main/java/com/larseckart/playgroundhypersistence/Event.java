package com.larseckart.playgroundhypersistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_id", updatable = false, nullable = false)
  Long id;

  @Column(name = "event_name", nullable = false, updatable = false)
  private String eventName;

  @Column(name = "created_time", nullable = false, updatable = false)
  private LocalDateTime createdTime;

  public Event() {
  }

  public Event(String eventName, LocalDateTime createdTime) {
    this.eventName = eventName;
    this.createdTime = createdTime;
  }
}
