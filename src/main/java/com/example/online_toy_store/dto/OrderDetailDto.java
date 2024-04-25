package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class OrderDetailDto {
    String productId;
    String quantity;
    String orderComment;


}
