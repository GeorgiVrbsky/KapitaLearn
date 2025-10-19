package com.giorge.kapitalearndev.service;

import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.entity.UserUpdateDTO;
import com.giorge.kapitalearndev.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Transactional
    public void DeleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Transactional
    public User updateUser(String email, UserUpdateDTO updates) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new RuntimeException("User not found");
        }

        if (updates.getFirst_name() != null) {
            user.setFirst_name(updates.getFirst_name());
        }

        if (updates.getLast_name() != null) {
            user.setLast_name(updates.getLast_name());
        }

        if (updates.getPassword() != null) {
            user.setPassword(updates.getPassword());
        }

        if (updates.getMoney() != null) {
            user.setMoney(updates.getMoney());
        }

        if (updates.getSalary() != null) {
            user.setSalary(updates.getSalary());
        }

        return userRepository.save(user);
    }




}
