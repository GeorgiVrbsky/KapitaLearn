package com.giorge.kapitalearndev;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //FIRST NAME A LAST NAME
    private String first_name;
    private String last_name;

    //EMAIL
    @Column(unique = true)
    private String email;

    //PASSWORD
    private String password;
    //SALARY
    private Double salary;
    //MONEY
    private Double money;

    //ROLE ENUM
    @Enumerated(EnumType.STRING)
    private Role role;

    //constructor ROLE
    public enum Role {
        USER,
        ADMIN
    }
}
