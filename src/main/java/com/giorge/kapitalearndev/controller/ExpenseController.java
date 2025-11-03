package com.giorge.kapitalearndev.controller;

import com.giorge.kapitalearndev.entity.Expense;
import com.giorge.kapitalearndev.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/{userId}")
    public List<Expense> getExpense(@PathVariable String userId){
        return expenseService.getExpenseById(Integer.parseInt(userId));
    }

    @PutMapping("/{userId}")
    public void loadExpenses(@PathVariable Integer userId) throws Exception {
        expenseService.generateInitialExpense(userId);
    }
}
