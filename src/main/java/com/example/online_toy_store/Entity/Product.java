package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@ToString
public class Product {
    private UUID pId;
    private String name;
    private	String description;
    private BigDecimal price;
    private int availableQuantity;
    private Category category;
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
