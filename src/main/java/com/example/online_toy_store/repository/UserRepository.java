package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.entity.enums.Country;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface  UserRepository extends JpaRepository<User, UUID> {
    @Nonnull
    @Override
    Optional<User> findById(@Nonnull UUID id);

    List<User> findAllByCountry(Country country);

    User findUserByUserInfoAddress(String address);

    User findByUserInfo_UserName(String username);
}
