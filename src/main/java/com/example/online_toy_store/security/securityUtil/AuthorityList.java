package com.example.online_toy_store.security.securityUtil;

public class AuthorityList {

    public static final String CUSTOMER = "CUSTOMER";
    public static final String ADMIN = "ADMIN";
    public static final String MANAGER = "MANAGER";
    public static final String SUPER_MANAGER = "SUPER_MANAGER";

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
            "/order/new",
            "/order/delete/**",
            "/order/dto/create",
//            "/product/showAllProducts",
            "/product/showProduct/*",
            "/promo/showByName/*",
            "/review/showReview/*",
            "/swagger-ui/index.html?continue#/USER_DTO/createUser"
    };

    public static final String[] ADMIN_LIST = {
            "/user/create",
            "/user/showAll",
            "/user/showUser/*",
            "/userInfo/showAll",
            "/userInfo/updateRoles/*",
            "/userInfo/getUserInfo/*"
    };

    public static final String[] MANAGER_LIST = {
            "/order/showOrder/*",


            "/promo/showAllByDiscount/*",
//            "/repository/OrderRepository/*"
    };

    public static final String[] SUPER_MANAGER_LIST = {
            "/product/showAllProducts",
            "/product/dto/create",
            "/promo/new",
            "/promo/showAll",
            "/promo/delete/*",
            "/supplier/new",
            "/supplier/showByName/*",
            "/supplier/showAll",
            "/user/getReport/*",
            "/user/getReport/**",
            "/user/getReport/***"
    };
}
