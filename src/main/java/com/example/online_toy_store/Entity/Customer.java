package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.City;
import com.example.online_toy_store.Entity.Enums.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @Column(name = "c_id")
    private UUID cId;

    private User user;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "card_number")
    private String cardNumber;

    private Set<Order> customerOrders;

    private Set<Review> customerReviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cId, customer.cId) && Objects.equals(createdAt, customer.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, createdAt);
    }
}
