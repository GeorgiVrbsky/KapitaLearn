package com.giorge.kapitalearndev.controller;

import com.giorge.kapitalearndev.entity.Stock;
import com.giorge.kapitalearndev.repository.StockRepository;
import com.giorge.kapitalearndev.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/all")
    public List<Stock> getAll() {
        return stockService.getAll();
    }
}
