package com.example.online_toy_store.service.interf;

import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.User;

public interface UserServices {
    User showUser(String id);

    UserReportDtoAfter getTopUsers(String month, String year, String country);
}
