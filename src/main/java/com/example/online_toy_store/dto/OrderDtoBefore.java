package com.example.online_toy_store.dto;

import lombok.Data;

import java.util.Set;

@Data
public class OrderDtoBefore {
    String userId;
    String promoName;
    Set<OrderDetailDto> orderDetailsDto;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public Set<OrderDetailDto> getOrderDetailsDto() {
        return orderDetailsDto;
    }

    public void setOrderDetailsDto(Set<OrderDetailDto> orderDetailsDto) {
        this.orderDetailsDto = orderDetailsDto;
    }
}
