package com.giorge.kapitalearndev.controller;

import com.giorge.kapitalearndev.entity.Stock;
import com.giorge.kapitalearndev.entity.User;
import com.giorge.kapitalearndev.repository.StockRepository;
import com.giorge.kapitalearndev.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAll() {
        return stockService.getAll();
    }

    @GetMapping("/{name}")
    public Stock getStock(@PathVariable String name) {
        return stockService.getStockByName(name);
    }

    @GetMapping("/{name}/quantity")
    public Double getStockQuantity(@PathVariable String name) {
        return stockService.getStockQuantityByName(name);
    }

    @GetMapping("/{name}/price")
    public Double getStockPrice(@PathVariable String name) {
        return stockService.getStockPriceByName(name);
    }
}
