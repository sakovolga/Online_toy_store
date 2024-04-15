package com.example.online_toy_store.dto;

import com.example.online_toy_store.entity.Product;
import lombok.Data;

@Data
public class OrderDetailDto {
    String productId;
    String quantity;
    String orderComment;


}
