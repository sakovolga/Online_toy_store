package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class OrderDetailDtoAfter {
    String productName;
    String price;
    String quantity;
    String comment;
}
