package com.ecam.calendar.model;


import javax.persistence.*;
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



    public Integer getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

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

    public void setCode(String code) {

    }

    public String getRoom() {
        return room;
    }

    public  void setRoom(String code) {
        this.room = room;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public Integer getsessionNumber() {
        return sessionNumber;
    }

    public void setsessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }


    public Time getStartTime() {
        return startTime;
    }

    public  void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Date weekDay) {
        this.weekDay = weekDay;
    }

}






















