package com.ecam.calendar.model;

import javax.persistence.*;

/**
 * Cette classe est le "template" de user et contient les get/set afin de modifier ses parametres
 */

@Entity
@Table(name = "user")
public class User {


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
    public int getMatricule() {
        return matricule;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setRole(String role) {
        this.role = role;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userId;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="role")
    private String role;
    @Column(name="matricule")
    private int matricule;






    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}