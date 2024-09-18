package com.example.online_toy_store.dto;

public class UserInfoUpdateRolesDto {
    Boolean isCustomer;
    Boolean isManager;
    Boolean isSuper_manager;
    Boolean isAdmin;

    public Boolean getCustomer() {
        return isCustomer;
    }

    public void setCustomer(Boolean customer) {
        isCustomer = customer;
    }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public Boolean getSuper_manager() {
        return isSuper_manager;
    }

    public void setSuper_manager(Boolean super_manager) {
        isSuper_manager = super_manager;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
