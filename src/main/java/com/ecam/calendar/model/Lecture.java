package com.ecam.calendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String code;
    private String room;
    private Time startTime;
    private Time endTime;
    private Integer sessionNumber;
    private String teachers;
    private Date weekDay;


    protected Lecture() {}

    public Lecture(String code, String room , Time startTime, Time endTime, Integer sessionNumber, String teachers, Date weekDay) {
        this.code = code;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionNumber = sessionNumber;
        this.teachers = teachers;
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return String.format(
                "Lecture[id=%d, code='%s', room='%s']",
                id, code, room);
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getRoom() {
        return room;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Integer getSessionNumber() {
        return sessionNumber;
    }

    public String getTeachers() {
        return teachers;
    }

    public Date getWeekDay() {
        return weekDay;
    }
}