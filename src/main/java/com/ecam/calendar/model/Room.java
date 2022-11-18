package com.ecam.calendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String type;
    private Integer capacity;

    protected Room() {}

    public Room(String type, Integer capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format(
                "Room[id=%d, type='%s', capacity='%d']",
                id, type, capacity);
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getCapacity() {
        return capacity;
    }
}