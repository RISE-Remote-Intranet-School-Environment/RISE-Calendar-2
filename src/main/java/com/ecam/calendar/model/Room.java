package com.ecam.calendar.model;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String type;
    private Integer capacity;

    public static List<Lecture> getLectures() {
        return lectures;
    }

    @ManyToMany(mappedBy = "rooms")
    public static List<Lecture> lectures = new ArrayList<>();


    public Room() {}

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

    public void setId(Long id) {
        this.id = id;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}