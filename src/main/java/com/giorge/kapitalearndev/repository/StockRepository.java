package com.giorge.kapitalearndev.repository;

import com.giorge.kapitalearndev.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository<Stock, Integer> {

    Stock findByName(String name);

}
