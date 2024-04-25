package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.ShowAllUsersInfo;
import com.example.online_toy_store.annotation.ShowUserInfoById;
import com.example.online_toy_store.annotation.UpdateUserInfoRoles;
import com.example.online_toy_store.dto.UserInfoRolesResponse;
import com.example.online_toy_store.dto.UserInfoUpdateRolesDto;
import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.service.interf.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @UpdateUserInfoRoles(path = "/updateRoles/{uiId}")
    public UserInfoRolesResponse updateUserInfoRoles(@PathVariable (name = "uiId") String uiId,
                                                     @RequestBody UserInfoUpdateRolesDto userInfoUpdateRolesDto){
        return userInfoService.updateUserInfo(uiId, userInfoUpdateRolesDto);
    }

    @ShowUserInfoById(path = "/getUserInfo/{id}")
    public UserInfo showUserInfoById(@PathVariable(name = "id") String id) {
        return userInfoService.showUserInfo(id);
    }
}
