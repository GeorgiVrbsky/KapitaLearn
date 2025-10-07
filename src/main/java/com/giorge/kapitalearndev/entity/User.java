package com.giorge.kapitalearndev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;
    private String last_name;

    @Column(unique = true)
    private String email;

    private String password;
    private Double salary;
    private Double money;

    @Enumerated(EnumType.STRING)
    private Role role;


    public enum Role {
        user,
        admin
    }

}
