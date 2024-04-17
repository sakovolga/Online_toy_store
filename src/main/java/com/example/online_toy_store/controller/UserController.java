package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.GetTopUsers;
import com.example.online_toy_store.annotation.ShowUserById;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @ShowUserById(path = "/showUser/{id}")
    public User showUserById(@PathVariable(name = "id") String id) {
        return userServices.showUser(id);
    }

    @GetTopUsers(path = "/getReport/{month}/{year}/{country}")
    public UserReportDtoAfter getTopUsers(@PathVariable(name = "month") String month,
                                          @PathVariable(name = "year") String year,
                                          @PathVariable(name = "country") String country) {
        return userServices.getTopUsers(month, year, country);
    }
}
