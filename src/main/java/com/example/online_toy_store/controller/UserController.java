package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.service.interf.UserServices;
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
    @GetMapping("/showUser/{id}")
    public User showUserById(@PathVariable(name = "id") String id)  {
       return userServices.showUser(id);
    }
}
