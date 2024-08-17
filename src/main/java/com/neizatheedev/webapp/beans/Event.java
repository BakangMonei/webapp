package com.neizatheedev.webapp.beans;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    private String eventId;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private int capacity;
    private List<String> registeredUsers;

    public Event(String eventId, String title, String description, LocalDateTime dateTime, String location, int capacity, List<String> registeredUsers) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.location = location;
        this.capacity = capacity;
        this.registeredUsers = registeredUsers;
    }

    public Event(){}

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<String> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }
}
