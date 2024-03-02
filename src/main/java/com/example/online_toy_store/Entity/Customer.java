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
public class Customer {
    private UUID cId;
    private String firstName;
    private String lastName;
    private String address;
    private City city;
    private String postalCode;
    private Country country;
    private String cardNumber;
    private Set<Order> customerOrders;
    private Set<Review> customerReviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cId, customer.cId) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, firstName, lastName);
    }
}
