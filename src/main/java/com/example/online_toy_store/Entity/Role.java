package com.example.online_toy_store.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role {

    @Id
    @Column(name = "r_id")
    private UUID rId;

    @Column(name = "role_name")
    private String roleName;

    private Set<User> users;

    private Set<Authority> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(rId, role.rId) && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, roleName);
    }
}
