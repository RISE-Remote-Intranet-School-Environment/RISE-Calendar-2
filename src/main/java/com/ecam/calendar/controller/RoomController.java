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
     *         "courseId":1,
     *         "name":"fluid dynamics and microbiology applied to ethics",
     *         "teacher":"Dr fun",
     *         "ue":"ethics101",
     *         "year:1
     *     }
     *
     * @param room new course
     * @return the new course
     */
    @RequestMapping(value="/rooms", method= RequestMethod.POST)
    public Room createRoom(@RequestBody Room room) {
        return RoomService.createRoom(room);
    }


    /**
     * Read all the courses in the database
     *
     *
     * @return all the courses
     */
    @RequestMapping(value="/rooms", method=RequestMethod.GET)
    public List<Room> readCourses() {
        return RoomService.getRooms();
    }


    /**
     * read a course by its id
     *
     * @param id id of the course to be read
     * @return the course linked to the provided id
     */
    @RequestMapping(value="/{roomId}", method=RequestMethod.GET)
    public Optional<Room> readCourseById(@PathVariable(value = "roomId") Long id) {
        return RoomService.getRoomById(id);
    }

    /**
     * update a course which already exists
     *
     * body needs to look like :    {
     *         "courseId":1,
     *         "name":"fluid dynamics and microbiology applied to ethics",
     *         "teacher":"Dr fun",
     *         "ue":"ethics101",
     *         "year:1
     *     }
     *
     * @param id id of the course to be updated
     * @param roomDetails new course data
     * @return the updated course
     */
    @RequestMapping(value="/rooms/{roomId}", method=RequestMethod.PUT)
    public Room updateCourses(@PathVariable(value = "roomId") Long id, @RequestBody Room roomDetails) {
        return RoomService.updateRoom(id, roomDetails);
    }


    /**
     * delete a course
     *
     * @param id id of the course to be deleted
     */
    @RequestMapping(value="/{roomId}", method=RequestMethod.DELETE)
    public void deleteRoom(@PathVariable(value = "roomId") Long id) {
        RoomService.deleteRoom(id);
    }

    /**
     * read all the course in an ue
     *
     * @param ue ue for which you wish to find the courses
     * @return list of courses linked to the provided ue
     */
    /*@RequestMapping(value="/getByUE/{ue}", method=RequestMethod.GET)
    public List<Room> getCoursesByUE(@PathVariable(value = "ue") String ue) {
        return courseService.getCoursesByUE(ue);
    }*/

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