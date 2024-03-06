package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.City;
import com.example.online_toy_store.Entity.Enums.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "suppliers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Supplier {

    @Id
    @Column(name = "s_id")
    private UUID sId;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private Country country;

    private Set<Product> products;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(sId, supplier.sId) && Objects.equals(name, supplier.name) && Objects.equals(contactName, supplier.contactName) && Objects.equals(phone, supplier.phone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sId, name, contactName, phone);
    }
}
