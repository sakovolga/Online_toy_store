package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CreateUserDto;
import com.example.online_toy_store.annotation.GetTopUsers;
import com.example.online_toy_store.annotation.ShowAllUsers;
import com.example.online_toy_store.annotation.ShowUserById;
import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserCreatedDto;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

    @CreateUserDto(path = "/create")
    public UserCreatedDto createUser(@RequestBody UserBeforeCreatingDto userBeforeCreatingDto){
        return userServices.createUser(userBeforeCreatingDto);
    }

    @ShowAllUsers(path = "/showAll")
    public List<User> showAll(){
        return userServices.showAll();
    }

    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }
}
