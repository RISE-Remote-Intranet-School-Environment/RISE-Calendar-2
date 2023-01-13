package com.ecam.calendar.service;


import com.ecam.calendar.model.Lecture;
import com.ecam.calendar.model.mapLectureUserModel;
import com.ecam.calendar.repository.LectureRepository;
import com.ecam.calendar.repository.mapLectureUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class mapLectureUserService {

    @Autowired
    mapLectureUserRepository mapLectureUserRepository;

    @Autowired
    LectureRepository lectureRepository;

    // CREATE
    public mapLectureUserModel createMapLectureUser(mapLectureUserModel mapLectureUser) {
        return mapLectureUserRepository.save(mapLectureUser);
    }

    // READ
    public List<mapLectureUserModel> getMapLectureUser() {
        return mapLectureUserRepository.findAll();
    }

    //READ by id
    public Optional<mapLectureUserModel> getMapById(Long mapId){return mapLectureUserRepository.findById(mapId);}

    // DELETE
    public void deleteMapLectureUser(Long mapLectureUserId) {
        mapLectureUserRepository.deleteById(mapLectureUserId);
    }

    // UPDATE
    public mapLectureUserModel updateMapLectureUser(Long mapLectureUserId, mapLectureUserModel mapLectureUserDetails) {
        mapLectureUserModel mapLectureUser = mapLectureUserRepository.findById(mapLectureUserId).get();
        mapLectureUser.setIdMapLectureUser(mapLectureUserDetails.getIdMapLectureUser());
        mapLectureUser.setFkuser(mapLectureUserDetails.getFkuser());
        mapLectureUser.setFklecture(mapLectureUserDetails.getFklecture());

        return mapLectureUserRepository.save(mapLectureUser);
    }

    //find documents by course id
    public List<Optional<Lecture>> getLectureByUserId(Long id){
        List<mapLectureUserModel> list= mapLectureUserRepository.findAllByfkuser(id);
        List<Optional<Lecture>> lectureList = new ArrayList<Optional<Lecture>>();
        for (mapLectureUserModel map:list) {
            lectureList.add(lectureRepository.findById(map.getFkuser()));
        }
        return lectureList;
    }
}