package com.ecam.calendar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roomid")
    private long roomid;

    @Column(name="capacity")
    private Integer capacity;

    @Column(name="type")
    private String type;


    public long getRoomId() {
        return roomid;
    }

    public void setRoomId(long roomId) {
        this.roomid = roomId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}