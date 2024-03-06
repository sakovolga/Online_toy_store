package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.City;
import com.example.online_toy_store.Entity.Enums.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "u_id")
    private UUID uID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private Country country;

    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uID, user.uID) && Objects.equals(userName, user.userName) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uID, userName, firstName, lastName);
    }
}
