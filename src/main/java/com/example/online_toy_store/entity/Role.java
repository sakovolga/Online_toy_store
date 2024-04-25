package com.example.online_toy_store.entity;

import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "r_id")
    private UUID rId;

    @Column(name = "role_name")
    private String roleName;

//    @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<UserInfo> users;

//    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        return "Role{" +
                "rId=" + rId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
