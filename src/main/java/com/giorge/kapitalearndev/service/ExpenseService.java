package com.giorge.kapitalearndev.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.giorge.kapitalearndev.entity.Expense;
import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.model.ExpenseTemplate;
import com.giorge.kapitalearndev.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getExpenseById(int userId) {
        return expenseRepository.findByUserId(userId);
    }

    public void generateInitialExpense(Integer userId) throws Exception {
        List<ExpenseTemplate> expenseTemplateList = getExpenseTemplateFromJSON();

        List<Expense> expensesToSave = new ArrayList<>();

        for(ExpenseTemplate expenseTemplate : expenseTemplateList) {

            Expense expense = new Expense();

            expense.setUserId(userId);
            expense.setCategory(expenseTemplate.getCategory());
            expense.setPrice(variationPrice(expenseTemplate.getBasePrice(), expenseTemplate.getVariationPercent()));
            expense.setMonth("1");
            expense.setYear("2025");
            expense.setPaid(expenseTemplate.isPaidDefault());
            expense.setName(expenseTemplate.getName());
            expense.setDescription(expenseTemplate.getDescription());
            expensesToSave.add(expense);
        }
        expenseRepository.saveAll(expensesToSave);
    }

    //udelat tady jeste relativni cestu
    private List<ExpenseTemplate> getExpenseTemplateFromJSON() throws Exception {
        Path path = Paths.get("src/main/resources/default_expense.json");
        String json = "";
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<>(){}
        );

    }

    private double variationPrice(double basePrice, double variationPercent) {
        if(variationPercent == 0){
            return basePrice;
        }

        double max = basePrice * (1 + variationPercent);
        double min = basePrice * (1 - variationPercent);

        double price = min + (max - min) * Math.random();
        return Math.round(price);
    }








}
