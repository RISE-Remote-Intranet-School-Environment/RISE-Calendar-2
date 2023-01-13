package com.ecam.calendar.controller;


import com.ecam.calendar.model.Lecture;
import com.ecam.calendar.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    LectureService LectureService;


    @RequestMapping(value="/lectures", method= RequestMethod.POST)
    public Lecture createLecture(@RequestBody Lecture lecture) {
        return LectureService.createLecture(lecture);
    }



    @RequestMapping(value="/lectures", method=RequestMethod.GET)
    public List<Lecture> readLectures() {
        return LectureService.getLectures();
    }



    @RequestMapping(value="/{lectureId}", method=RequestMethod.GET)
    public Optional<Lecture> readLectureById(@PathVariable(value = "lectureId") Long lectureId) {
        return LectureService.getLectureById(lectureId);
    }


    @RequestMapping(value="/lectures/{lectureId}", method=RequestMethod.DELETE)
    public void deleteLecture(@PathVariable(value = "lectureId") Long id) {
        LectureService.deleteLecture(id);
    }


    @RequestMapping(value="/getByCode/{code}", method=RequestMethod.GET)
    public List<Lecture> getLecturesByCode(@PathVariable(value = "code") String code) {
        return LectureService.getLecturesByCode(code);
    }




}