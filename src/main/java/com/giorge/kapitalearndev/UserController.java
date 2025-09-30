package com.giorge.kapitalearndev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Přidání uživatele přes POST
    @PostMapping("/add")
    public User addUser(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String password) {
        return userService.createUser(firstName, lastName, email, password);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
