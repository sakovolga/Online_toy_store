package com.example.online_toy_store.dto;

import com.example.online_toy_store.entity.Role;
import lombok.Data;

import java.util.Set;
@Data
public class UserInfoRolesResponse {
    String answer = "Roles were updated successfully";
    String uID;
    String userName;
    Set<Role> roles;
}
