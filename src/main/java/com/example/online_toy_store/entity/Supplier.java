package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.entity.enums.Country;
import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "suppliers")
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

    public UUID getsId() {
        return sId;
    }

    public void setsId(UUID sId) {
        this.sId = sId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

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

    @Override
    public String toString() {
        return "Supplier{" +
                "sId=" + sId +
                ", supplierName='" + supplierName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
