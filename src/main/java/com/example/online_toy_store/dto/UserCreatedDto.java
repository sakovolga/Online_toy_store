package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class UserCreatedDto {
    String answer = "Congratulations! User successfully created";
    String firstName;
    String lastName;
    String createdAt;
    String country;
    String address;
    String city;
    String postalCode;
    String email;
}
