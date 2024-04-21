package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.ShowAllUsers;
import com.example.online_toy_store.annotation.ShowAllUsersInfo;
import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.service.interf.UserInfoService;
import com.example.online_toy_store.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;
    @ShowAllUsersInfo(path = "/showAll")
    public List<UserInfo> showAll(){
        return userInfoService.showAll();
    }
}
