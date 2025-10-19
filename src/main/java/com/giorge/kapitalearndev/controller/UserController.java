package com.giorge.kapitalearndev.controller;

import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.entity.UserUpdateDTO;
import com.giorge.kapitalearndev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.CreateUser(user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        userService.DeleteUserByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody UserUpdateDTO updates) {
        User updatedUser = userService.updateUser(email, updates);
        return ResponseEntity.ok(updatedUser);
    }





}
