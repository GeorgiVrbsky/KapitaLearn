package com.giorge.kapitalearndev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expenses")
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
