package com.food.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String user;
    private String password;
}
