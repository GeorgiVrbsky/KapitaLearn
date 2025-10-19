package com.giorge.kapitalearndev.controller;

import com.giorge.kapitalearndev.entity.UserStocks;
import com.giorge.kapitalearndev.repository.UserStocksRepository;
import com.giorge.kapitalearndev.service.UserStocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userStocks")
public class UserStocksController {

    @Autowired
    private UserStocksService userStocksService;

    @PostMapping
    public UserStocks addUserStocks(@RequestParam Integer userId, @RequestParam Integer stockId, @RequestParam Integer quantity) {
        return userStocksService.addStockToUser(userId, stockId, quantity);
    }

    @GetMapping
    public List<UserStocks> getAllUserStocks() {
        return userStocksService.getAllUserStocks();
    }

    @GetMapping("/{userId}")
    public List<UserStocks> getAllUserStocksById(@PathVariable Integer userId) {
        return userStocksService.getAllUserStocksById(userId);
    }

    @PostMapping
}
