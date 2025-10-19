package com.giorge.kapitalearndev.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    private String first_name;
    private String last_name;
    private String password;
    private Double money;
    private Double salary;
}
