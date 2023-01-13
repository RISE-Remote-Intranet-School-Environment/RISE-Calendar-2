package com.ecam.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecam.calendar.model.User;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {

}