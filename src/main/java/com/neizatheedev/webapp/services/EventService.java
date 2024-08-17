package com.neizatheedev.webapp.services;
import com.neizatheedev.webapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(String id, Event updatedEvent) {
        updatedEvent.setId(id); // Ensure the ID is set for update
        return eventRepository.save(updatedEvent);
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
