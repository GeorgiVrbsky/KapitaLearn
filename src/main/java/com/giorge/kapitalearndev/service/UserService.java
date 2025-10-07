package com.giorge.kapitalearndev.service;

import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User CreateUser(String first_name, String last_name, String email, String password) {
        User user = new User();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setEmail(email);
        user.setPassword(password);
        user.setMoney(0.0);
        user.setSalary(0.0);
        user.setRole(User.Role.user);

        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
