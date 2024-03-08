package com.example.online_toy_store.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "com.example.online_toy_store.generator.UuidTimeSequenceGenerator")
    @Column(name = "od_id")
    private UUID odId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "o_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_comment")
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
