package com.example.online_toy_store.dto;

import lombok.Data;

@Data
public class UserInfoUpdateRolesDto {
    Boolean isCustomer;
    Boolean isManager;
    Boolean isSuper_manager;
    Boolean isAdmin;

}
