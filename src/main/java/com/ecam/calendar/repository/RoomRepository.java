package com.ecam.calendar.repository;
import com.ecam.calendar.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer>  {
}