package com.giorge.kapitalearndev.repository;

import com.giorge.kapitalearndev.entity.UserStocks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStocksRepository extends JpaRepository<UserStocks, Integer> {

    List<UserStocks> findByUserId(Integer userId);

}
