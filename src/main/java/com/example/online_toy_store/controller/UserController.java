package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CustomShowUserById;
import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.service.interf.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @CustomShowUserById(path = "/showUser/{id}")
    public User showUserById(@PathVariable(name = "id") String id)  {
       return userServices.showUser(id);
    }
}
