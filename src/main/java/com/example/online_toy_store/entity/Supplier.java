package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.entity.enums.Country;
import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Supplier {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "s_id")
    private UUID sId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(sId, supplier.sId) && Objects.equals(supplierName, supplier.supplierName) && Objects.equals(phone, supplier.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, supplierName, phone);
    }
}
