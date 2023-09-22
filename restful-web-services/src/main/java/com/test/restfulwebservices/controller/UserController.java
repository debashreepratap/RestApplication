package com.test.restfulwebservices.controller;

import com.test.restfulwebservices.dao.UserDao;
import com.test.restfulwebservices.exception.UserNotFoundException;
import com.test.restfulwebservices.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userDao.getUserById(id);
        if(user == null){
            throw new UserNotFoundException("id :"+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = userDao.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                           .path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDao.deleteUserById(id);
    }
}
