package com.ecam.calendar.controller;

import com.ecam.calendar.model.Lecture;
import com.ecam.calendar.model.mapLectureUserModel;
import com.ecam.calendar.service.mapLectureUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("mapLectureUser")
public class mapLectureUserController {

    @Autowired
    mapLectureUserService mapLectureUserService;


    /**
     * post NEW mapDocuCourse
     *
     * body needs to look like :    {
     *              "idmapdocuorder":1,
     *              "fkdocument":1,
     *              "fkorder":1
     *          }
     *
     * @param mapDocuCourse map to be posted
     * @return the posted map
     */
    @RequestMapping(value="/mapLectureUsers", method= RequestMethod.POST)
    public mapLectureUserModel createMapLectureUser(@RequestBody mapLectureUserModel mapLectureUser) {
        return mapLectureUserService.createMapLectureUser(mapLectureUser);
    }

    /**
     * read all the maps stored in database
     *
     * @return all the map stored in database
     */
    @RequestMapping(value="/mapLectureUsers", method=RequestMethod.GET)
    public List<mapLectureUserModel> readMapLectureUser() {
        return mapLectureUserService.getMapLectureUser();
    }

    /**
     * read a specific map by its id
     *
     * @param id id of the map to be returned
     * @return the map which as the provided id
     */
    @RequestMapping(value="/{mapId}", method=RequestMethod.GET)
    public Optional<mapLectureUserModel> readMapById(@PathVariable(value = "mapId") Long id) {
        return mapLectureUserService.getMapById(id);
    }


    /**
     * update a map which already exists
     *
     * body needs to look like :    {
     *         "idmapdocuorder":1,
     *         "fkdocument":1,
     *         "fkorder":1
     *     }
     *
     * @param id id of the map to be updated
     * @param mapDocuCourseDetails new map data
     * @return the updated map
     */

    @RequestMapping(value="/mapLectureUsers/{mapLectureUserId}", method=RequestMethod.PUT)
    public mapLectureUserModel updateMapLectureUsers(@PathVariable(value = "mapLectureUserId") Long id, @RequestBody mapLectureUserModel mapLectureUserDetails) {
        return mapLectureUserService.updateMapLectureUser(id, mapLectureUserDetails);
    }

    /**
     * delete a map
     *
     * @param id id of the map to be deleted
     */
    @RequestMapping(value="/mapLectureUsers/{mapLectureUserId}", method=RequestMethod.DELETE)
    public void deleteMapLectureUser(@PathVariable(value = "mapDocuCourseId") Long id) {
        mapLectureUserService.deleteMapLectureUser(id);
    }

    /**
     * read all the documents linked to a course
     *
     * @param id id of the course for which you wish to find the documents
     * @return list of document
     */
    @RequestMapping(value="/getDocsByCourseId/{courseId}", method=RequestMethod.GET)
    public List<Optional<Lecture>> readLecturesByUserId(@PathVariable(value = "userid") Long id) {
        return mapLectureUserService.getLectureByUserId(id);
    }

}