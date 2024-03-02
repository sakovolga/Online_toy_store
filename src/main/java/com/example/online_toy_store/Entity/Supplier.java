package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.City;
import com.example.online_toy_store.Entity.Enums.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@ToString
public class Supplier {
    private UUID sId;
    private String name;
    private String contactName;
    private String phone;
    private String address;
    private City city;
    private String postalCode;
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
