package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import java.util.Set;
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @Column(name = "o_id")
    private UUID oId;

    private User user;

    @Column(name = "order_date")
    private LocalDate orderDate;

    private PromoCode promoCode;

    @Column(name = "order_status")
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
