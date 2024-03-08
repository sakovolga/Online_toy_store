package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.City;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserInfo {

    @Id
    @Column(name = "ui_id")
    private UUID uID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "email")
    private String email;

    @Column(name = "card_number")
    private String cardNumber;

    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(uID, userInfo.uID) && Objects.equals(userName, userInfo.userName) && Objects.equals(password, userInfo.password) && Objects.equals(postalCode, userInfo.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uID, userName, password, postalCode);
    }
}
