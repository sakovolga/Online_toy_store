package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.dto.UserInfoRolesResponse;
import com.example.online_toy_store.dto.UserInfoUpdateRolesDto;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> showAll();

    UserInfoRolesResponse updateUserInfo(String uiId, UserInfoUpdateRolesDto userInfoUpdateRolesDto);

    UserInfo showUserInfo(String id);
}
