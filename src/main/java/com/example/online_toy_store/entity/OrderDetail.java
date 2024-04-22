package com.example.online_toy_store.entity;

import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "od_id")
    private UUID odId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_comment")
    private String orderComment;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "o_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;

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

    @Override
    public String toString() {
        return "OrderDetail{" +
                "odId=" + odId +
                ", quantity=" + quantity +
                ", orderComment='" + orderComment + '\'' +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
