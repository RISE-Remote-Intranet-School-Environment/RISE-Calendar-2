package com.ecam.calendar.repository;
import com.ecam.calendar.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
