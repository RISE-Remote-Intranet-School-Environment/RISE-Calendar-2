package com.ecam.calendar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lectureid")
    private long lectureId;

    @Column(name = "code")
    private String code;

    @Column(name = "room")
    private String room;

    @Column(name = "starttime")
    private Time startTime;

    @Column(name = "endtime")
    private Time endTime;

    @Column(name = "sessionnumber")
    private Integer sessionNumber;

    @Column(name = "teachers")
    private String teachers;

    @Column(name = "weekday")
    private Date weekDay;


    public long getLectureId() {
        return lectureId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public String getCode() {
        return code;
    }

    public static void setCode(String code) {
        this.code = code;
    }

    public String getRoom() {
        return room;
    }

    public static void setRoom(String code) {
        this.room = room;
    }

    public String getTeachers() {
        return teachers;
    }

    public static void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public Integer getsessionNumber() {
        return sessionNumber;
    }

    public static void setsessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }


    public Time getStartTime() {
        return startTime;
    }

    public static void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public static void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getWeekDay() {
        return weekDay;
    }

    public static void setWeekDay(Date weekDay) {
        this.weekDay = weekDay;
    }

}






















