package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class ProductAfterCreatingDto {
    String answer = "Product created successfully";
    String name;
    String description;
    String price;
    String availableQuantity;
    String category;
    String isAvailable;
    String supplierId;
    String supplierName;
    String phone;
    String country;
}
