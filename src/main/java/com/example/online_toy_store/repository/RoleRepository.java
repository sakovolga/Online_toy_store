package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRoleName(String roleName);
}
