package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.City;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "com.example.online_toy_store.generator.UuidTimeSequenceGenerator")
    @Column(name = "ui_id")
    private UUID uID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "email")
    private String email;

    @Column(name = "card_number")
    private String cardNumber;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
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
