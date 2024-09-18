package com.example.online_toy_store.dto;

import java.util.Set;

public class OrderDtoAfter {
    String answer;
    String orderDate;
    String orderStatus;
    Set<OrderDetailDtoAfter> orderDetails;
    String orderCost;
    String discount;
    String discountedOrderCost;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderDetailDtoAfter> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailDtoAfter> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountedOrderCost() {
        return discountedOrderCost;
    }

    public void setDiscountedOrderCost(String discountedOrderCost) {
        this.discountedOrderCost = discountedOrderCost;
    }
}
