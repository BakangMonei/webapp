package com.neizatheedev.webapp.repository;

import com.neizatheedev.webapp.beans.Event;

public interface EventRepository {
    Event save(Event event);
    Event findById(String id);
    void deleteById(String id);
    // Add other methods as needed for event operations
}
