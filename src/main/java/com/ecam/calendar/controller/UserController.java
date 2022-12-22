package com.ecam.calendar.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecam.calendar.model.User;
import com.ecam.calendar.service.UserService;

/**
 * This Class redirects '/user' to the apporpriate methods defined in the userService
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService UserService;

    /**
     * POST method '/user/users' creating users with params
     * body need to look like : {
     *      "userId": 5,
     *     "firstName": "Charles",
     *     "lastName": "Michel",
     *     "role": "student",
     *     "matricule": 0021
     * }
     * @param User param user object
     * @return new posted user
     */
    @RequestMapping(value="/users", method= RequestMethod.POST)
    public User createUser(@RequestBody User User) {
        return UserService.createUser(User);
    }

    /**
     * GET method '/user/users' returning users
     * @return list of all users
     */
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> readUsers() {
        return UserService.getUsers();
    }

    /**
     * GET method '/users/{userId}' returning user corresponding to id as param
     * @param id of the user to be returned
     * @return If it exist, the user
     */
    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public Optional<User> readUserById(@PathVariable(value = "userId") Long id) {
        return UserService.getUserById(id);
    }

    /**
     * PUT method '/user/users/{userId}' updating the user with the specified id
     * body need to look like : {
     *          "userId": 5,
     *      *    "firstName": "Charles",
     *      *    "lastName": "Michel",
     *      *    "role": "student",
     *      *    "matricule": 0021
     *    
     *    }
     *
     * @param id of the user to modify
     * @param userDetails details to modify with variables
     * @return the user modified
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
    public User updateUsers(@PathVariable(value = "userId") Long id, @RequestBody User userDetails) {
        return UserService.updateUser(id, userDetails);
    }

    /**
     * DELETE method 'user/users/{uderId}' with specified id of the user
     * @param id of the user to delete
     */
    @RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "userId") Long id) {
        UserService.deleteUser(id);
    }
}