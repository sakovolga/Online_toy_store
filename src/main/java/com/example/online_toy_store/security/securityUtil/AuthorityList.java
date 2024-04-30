package com.example.online_toy_store.security.securityUtil;

public class AuthorityList {

    public static final String CUSTOMER = "CUSTOMER";
    public static final String ADMIN = "ADMIN";

    public static final String[] CUSTOMER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/",
            "/webjars/**",
            "/configuration/**",
            "/public",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
            "/order/showAllOrders",
            "/*",
            "/**",
            "/user/create",
            "/swagger-ui/index.html?continue#/USER_DTO/createUser"
    };

    public static final String[] ADMIN_LIST = {
            "/order/showAllOrders"
    };
}
