package com.ecam.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecam.calendar.model.Room;
import com.ecam.calendar.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService RoomService;

    /**
     * add a new course to the database
     *
     * body needs to look like :    {
     *         "capacity": 21,
     *         "type": "2e44",
     *         "roomId": 1
     *     }
     *
     * @param room new room
     * @return the new room
     */
    @RequestMapping(value="/rooms", method= RequestMethod.POST)
    public Room createRoom(@RequestBody Room room) {
        return RoomService.createRoom(room);
    }


    /**
     * Read all the rooms in the database
     *
     *
     * @return all the rooms
     */
    @RequestMapping(value="/rooms", method=RequestMethod.GET)
    public List<Room> readRooms() {
        return RoomService.getRooms();
    }


    /**
     * read a room by its id
     *
     * @param id id of the room to be read
     * @return the room linked to the provided id
     */
    @RequestMapping(value="/{roomId}", method=RequestMethod.GET)
    public Optional<Room> readRoomById(@PathVariable(value = "roomId") Long id) {
        return RoomService.getRoomById(id);
    }

    /**
     * update a course which already exists
     *
     * body needs to look like :    {
     *
     *         "capacity": 21,
     *         "type": "2e44",
     *         "roomId": 1
     *     }
     *
     * @param id id of the room to be updated
     * @param roomDetails new room data
     * @return the updated room
     */
    @RequestMapping(value="/rooms/{roomId}", method=RequestMethod.PUT)
    public Room updateRooms(@PathVariable(value = "roomId") Long id, @RequestBody Room roomDetails) {
        return RoomService.updateRoom(id, roomDetails);
    }


    /**
     * delete a room
     *
     * @param id id of the room to be deleted
     */
    @RequestMapping(value="/rooms/{roomId}", method=RequestMethod.DELETE)
    public void deleteRoom(@PathVariable(value = "roomId") Long id) {
        RoomService.deleteRoom(id);
    }


    /**
     * read all the course in an academic year
     *
     * @param year academic year for which you wish to find the courses
     * @return list of courses linked to the provided year
     */
    /*@RequestMapping(value="/getCoursesByAcademicYear/{year}", method=RequestMethod.GET)
    public List<courseModel> getCoursesByAcademicYear(@PathVariable(value = "year") int year) {
        return courseService.getCoursesByAcademicYear(year);
    }*/

}