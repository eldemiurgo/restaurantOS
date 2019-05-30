package com.food.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private Integer id;
    private String description;
    private String type;
    private float price;
}
