package com.example.online_toy_store.repository;

import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

}
