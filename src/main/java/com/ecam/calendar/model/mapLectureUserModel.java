package com.ecam.calendar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map_lecture_user")
public class mapLectureUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmaplectureuser")
    private Long idMapLectureUser;

    @Column(name="fklecture")
    private Long fklecture;

    @Column(name="fkuser")
    private Long fkuser;

    public Long getFkuser() {
        return fkuser;
    }

    public void setFkuser(Long fkuser) {
        this.fkuser = fkuser;
    }

    public Long getFklecture() {
        return fklecture;
    }

    public void setFklecture(Long fklecture) {
        this.fklecture = fklecture;
    }

    public Long getIdMapLectureUser() {
        return idMapLectureUser;
    }

    public void setIdMapLectureUser(Long idMapLectureUser) {
        this.idMapLectureUser = idMapLectureUser;
    }
}