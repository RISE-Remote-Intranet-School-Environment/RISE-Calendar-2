package com.ecam.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecam.calendar.model.Room;
import com.ecam.calendar.repository.RoomRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository RoomRepository;

    // CREATE
    public Room createRoom(Room room) {
        return RoomRepository.save(room);
    }

    // READ
    public List<Room> getRooms() {
        return RoomRepository.findAll();
    }

    //READ by id
    public Optional<Room> getRoomById(Long roomId){return RoomRepository.findById(roomId);}

    // READ by teacher
    public List<Room> getRoomByTeacherId(String typeId){return RoomRepository.findAllByType(typeId);}
    // DELETE
    public void deleteRoom(Long roomId) {
        RoomRepository.deleteById(roomId);
    }

    // UPDATE
    public Room updateRoom(Long roomId, Room roomDetails) {
        Room room = RoomRepository.findById(roomId).get();
        room.setCapacity(roomDetails.getCapacity());
        room.setType(roomDetails.getType());

        return RoomRepository.save(room);
    }

    // read all courses linked to an ue
    public List<Room> getRoomsByCapacity(Integer capacity) {
        return RoomRepository.findAllByCapacity(capacity);
    }

    //read all courses linked to an academic year
    public List<Room> getRoomsByType(String type) {
        return RoomRepository.findAllByType(type);
    }
}