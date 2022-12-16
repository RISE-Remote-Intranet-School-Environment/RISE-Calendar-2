package com.ecam.calendar.model;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //@Column(nae)
    private Long id;
    private String code;
    private String room;
    private Time startTime;
    private Time endTime;
    private Integer sessionNumber;
    private String teachers;
    private Date weekDay;

    @ManyToMany(mappedBy = "lectures")
    public static List<User> users = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "link_lecture_room",
            joinColumns = @JoinColumn(name = "lecture_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms = new ArrayList<>();





    //Constructors, getters and setters removed for brevity


    /*public void addRooms(Room room) {
        rooms.add(room);
        room.getLectures().add(this);
    }

    public void removeRooms(Room room) {
        rooms.remove(room);
        room.getLectures().remove(this);
    }*/

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void setUsers(List<User> users) {
        Lecture.users = users;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Lecture() {}

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

    public static List<User> getUsers() { return users; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) { this.code = code; }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setSessionNumber(Integer sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public void setWeekDay(Date weekDay) {
        this.weekDay = weekDay;
    }
}