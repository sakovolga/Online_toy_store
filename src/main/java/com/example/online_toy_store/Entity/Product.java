package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "com.example.online_toy_store.generator.UuidTimeSequenceGenerator")
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

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "is_available")
    private boolean isAvailable;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "s_id")
    private Supplier supplier;

    @JsonBackReference
    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @JsonBackReference
    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
