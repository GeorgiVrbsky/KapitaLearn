package com.giorge.kapitalearndev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_stocks")
@Getter
@Setter
public class UserStocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="stock_id", nullable = false)
    private Stock stock;

    private Integer quantity;
}
