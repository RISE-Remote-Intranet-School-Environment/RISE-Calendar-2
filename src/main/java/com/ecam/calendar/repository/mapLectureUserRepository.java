package com.ecam.calendar.repository;


import com.ecam.calendar.model.mapLectureUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface mapLectureUserRepository extends JpaRepository<mapLectureUserModel, Long>{

    //function to find map by course id
    List<mapLectureUserModel> findAllByfkuser(Long id);
}