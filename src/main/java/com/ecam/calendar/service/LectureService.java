package com.ecam.calendar.service;


import com.ecam.calendar.model.Lecture;

import com.ecam.calendar.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    @Autowired
    LectureRepository lectureRepository;



    // CREATE
    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    // READ
    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    //READ by id
    public Optional<Lecture> getLectureById(Long lectureId){return lectureRepository.findById(lectureId);}

    // READ by teacher
    public List<Lecture> getLectureByteachers(String teachers){return lectureRepository.findAllByteachers(teachers);}
    // DELETE
    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }

    // UPDATE
    public Lecture updateLecture(Long lectureId, Lecture lectureDetails) {
        Lecture lecture = lectureRepository.findById(lectureId).get();
        lectureDetails.setCode(lectureDetails.getCode());
        lectureDetails.setRoom(lectureDetails.getRoom());
        lectureDetails.setTeachers(lectureDetails.getTeachers());
        lectureDetails.setsessionNumber(lectureDetails.getsessionNumber());
        lectureDetails.setStartTime(lectureDetails.getStartTime());
        lectureDetails.setEndTime(lectureDetails.getEndTime());
        lectureDetails.setWeekDay(lectureDetails.getWeekDay());








        return lectureRepository.save(lecture);
    }

    // read all courses linked to an ue
    public List<Lecture> getLecturesByCode(String code) {
        return lectureRepository.findAllBycode(code);
    }

    //read all courses linked to an academic year

}