package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class ProductBeforeCreatingDto {
    String name;
    String description;
    String price;
    String availableQuantity;
    String category;
    String isAvailable;
    String supplierName;
    String phone;
    String email;
    String address;
    String city;
    String postal_code;
    String country;
}
