package com.giorge.kapitalearndev.repository;

import com.giorge.kapitalearndev.entity.Expense;
import com.giorge.kapitalearndev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByUserId(int userId);
}
