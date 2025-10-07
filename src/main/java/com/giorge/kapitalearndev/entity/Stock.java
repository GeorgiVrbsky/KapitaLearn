package com.giorge.kapitalearndev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stocks")
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "price_of_one", nullable = false)
    private double priceOfOne;

    @Column(name = "total_amount")
    private Double totalAmount;

}
