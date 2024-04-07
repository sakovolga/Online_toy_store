package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users_info")
@NoArgsConstructor
@Getter
@Setter
public class UserInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_info_roles",
            joinColumns = @JoinColumn(name = "ui_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id"))
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(uID, userInfo.uID) && Objects.equals(userName, userInfo.userName) && Objects.equals(email, userInfo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uID, userName, email);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uID=" + uID +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
