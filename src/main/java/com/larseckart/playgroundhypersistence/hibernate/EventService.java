package com.larseckart.playgroundhypersistence.hibernate;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    @Transactional
    public void replaceALl(List<Event> events) {
        eventRepository.deleteAll();
        eventRepository.saveAll(events);
    }
}
