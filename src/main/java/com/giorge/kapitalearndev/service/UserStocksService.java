package com.giorge.kapitalearndev.service;

import com.giorge.kapitalearndev.entity.Stock;
import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.entity.UserStocks;
import com.giorge.kapitalearndev.repository.StockRepository;
import com.giorge.kapitalearndev.repository.UserRepository;
import com.giorge.kapitalearndev.repository.UserStocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStocksService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private UserStocksRepository userStocksRepository;

    public UserStocks addStockToUser(Integer userId, Integer stockId, Integer quantity) {

        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Stock stock =  stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        UserStocks userStocks = new UserStocks();
        userStocks.setUser(user);
        userStocks.setStock(stock);
        userStocks.setQuantity(quantity);

        return userStocksRepository.save(userStocks);
    }

    public List<UserStocks> getAllUserStocks() {
        return userStocksRepository.findAll();
    }

    public List<UserStocks> getAllUserStocksById(Integer userId) {
        return userStocksRepository.findByUserId(userId);
    }
}
