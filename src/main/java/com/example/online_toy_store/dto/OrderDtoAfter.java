package com.example.online_toy_store.dto;

import lombok.Data;

import java.util.Set;

@Data
public class OrderDtoAfter {
    String answer;
    String orderDate;
    String orderStatus;
    Set<OrderDetailDtoAfter> orderDetails;
    String orderCost;
    String discount;
    String discountedOrderCost;
}
