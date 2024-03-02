package com.example.online_toy_store.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@ToString
public class OrderDetail {
    private UUID odId;
    private Order order;
    private Product product;
    private int quantity;
    private String orderComment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return quantity == that.quantity && Objects.equals(odId, that.odId) && Objects.equals(orderComment, that.orderComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(odId, quantity, orderComment);
    }
}
