package com.larseckart.playgroundhypersistence;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public void replaceALl(String eventName, List<Event> events) {
        eventRepository.deleteAllByEventName(eventName);
        eventRepository.saveAll(events);
    }
}
