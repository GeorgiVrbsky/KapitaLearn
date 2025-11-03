package com.giorge.kapitalearndev.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseTemplate {

    private String category;
    private String name;
    private double basePrice;
    private double variationPercent;
    @JsonProperty("isPaidDefault")
    private boolean isPaidDefault;
    private String description;

    public ExpenseTemplate(){};

    public String toString(){
        return "Category" + category + "name" + name + "basePrice" + basePrice + "variationPercent" + variationPercent;
    }
}
