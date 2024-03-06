package com.example.online_toy_store.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {

    @Id
    @Column(name = "od_id")
    private UUID odId;

    private Order order;

    private Product product;

    @Column(name = "quantity")
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
