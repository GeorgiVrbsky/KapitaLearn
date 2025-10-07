package com.giorge.kapitalearndev.repository;

import com.giorge.kapitalearndev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
