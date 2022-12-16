package com.ecam.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecam.calendar.model.Lecture;

import java.util.List;
import java.util.Optional;

@Repository
public interface lectureRepository extends JpaRepository<Lecture, Long>{

    //function find a course by its ue
    Optional<Lecture> findBycode(String code);

    //function to find all courses linked to an ue
    List<Lecture> findAllBycode(String code);

    //function to find all the courses linked to a teacher
    List<Lecture> findAllByteachers(String teachers);

    //function to find all courses by academic year


}


