package com.giorge.kapitalearndev.service;

import com.giorge.kapitalearndev.entity.Stock;
import com.giorge.kapitalearndev.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public Stock getStockByName(String name) {
        return stockRepository.findByName(name);
    }
}
