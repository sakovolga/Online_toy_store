package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class UserBeforeCreatingDto {
    String userName;
    String password;
    String firstName;
    String lastName;
    String country;
    String address;
    String city;
    String postalCode;
    String email;
    String cardNumber;
}
