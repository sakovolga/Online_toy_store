package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @Column(name = "p_id")
    private UUID pId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private	String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "available_quantity")
    private int availableQuantity;

    private Category category;

    @Column(name = "is_available")
    private boolean isAvailable;

    private Supplier supplier;
    private Set<OrderDetail> orderDetails;
    private Set<Review> productReviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(pId, product.pId) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, name, description);
    }
}
