package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import java.util.Set;
@Getter
@Setter
@ToString
public class Order {
    private UUID oId;
    private Customer customer;
    private LocalDate orderDate;
    private PromoCode promoCode;
    private OrderStatus orderStatus;
    private Set<OrderDetail> orderDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(oId, order.oId) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, orderDate);
    }
}
