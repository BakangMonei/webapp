package com.neizatheedev.webapp.repository;

import com.neizatheedev.webapp.beans.*;

public interface EventRepository {
    Event save(Event event);
    Event findById(String id);
    void deleteById(String id);
    void UpdateUser(String id, User user);
    void CreateUser(String id, User user);


    // Add other methods as needed for event operations
}
