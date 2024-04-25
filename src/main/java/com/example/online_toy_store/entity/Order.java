package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.OrderStatus;
import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "o_id")
    private UUID oId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "promo_code_id", referencedColumnName = "pc_id")
    private PromoCode promoCode;

    @OneToMany(mappedBy = "order", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", promoCode=" + promoCode +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
