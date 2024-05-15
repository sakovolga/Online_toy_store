package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserCreatedDto;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.User;

import java.util.List;

public interface UserServices {
    User showUser(String id);

    UserReportDtoAfter getTopUsers(String month, String year, String country);

    UserCreatedDto createUser(UserBeforeCreatingDto userBeforeCreatingDto);

    List<User> showAll();

    User showByUserInfo_UserName(String username);
}
