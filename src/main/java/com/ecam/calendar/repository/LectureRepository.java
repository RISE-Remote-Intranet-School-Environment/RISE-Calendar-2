package com.ecam.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecam.calendar.model.Lecture;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long>{

    //function find a lecture by its code
    Optional<Lecture> findBycode(String code);

    //function to find all lectures linked to an code
    List<Lecture> findAllBycode(String code);

    //function to find all the lectures linked to a teacher
    List<Lecture> findAllByteachers(String teachers);




}


