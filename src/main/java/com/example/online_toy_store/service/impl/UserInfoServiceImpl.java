package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.repository.UserInfoRepository;
import com.example.online_toy_store.service.interf.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    @Override
    public List<UserInfo> showAll() {
        return userInfoRepository.findAll();
    }
}
