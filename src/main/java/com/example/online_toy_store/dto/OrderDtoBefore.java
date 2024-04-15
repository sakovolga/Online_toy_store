package com.example.online_toy_store.dto;

import lombok.Data;

import java.util.Set;

@Data
public class OrderDtoBefore {
    String userId;
    String promoName;
    Set<OrderDetailDto> orderDetailsDto;
}
