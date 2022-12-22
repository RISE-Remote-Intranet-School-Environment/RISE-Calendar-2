package com.ecam.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecam.calendar.model.Room;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    //function find a rooms by its capacity
    List<Room> findAllByCapacity(Integer capacity);

    //function to find all rooms linked to an type
    List<Room> findAllByType(String type);

}


