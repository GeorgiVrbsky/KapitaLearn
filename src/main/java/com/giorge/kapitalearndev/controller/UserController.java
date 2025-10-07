package com.giorge.kapitalearndev.controller;

import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestParam String first_name,
                        @RequestParam String last_name,
                        @RequestParam String email,
                        @RequestParam String password) {
        return userService.CreateUser(first_name, last_name, email, password);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

}
