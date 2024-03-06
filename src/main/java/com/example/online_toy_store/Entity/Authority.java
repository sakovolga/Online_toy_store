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
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Authority {

    @Id
    @Column(name = "a_id")
    private UUID aId;

    @Column(name = "authority_name")
    private String authorityName;

    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return Objects.equals(aId, authority.aId) && Objects.equals(authorityName, authority.authorityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, authorityName);
    }
}
