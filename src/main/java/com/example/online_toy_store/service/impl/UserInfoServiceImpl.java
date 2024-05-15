package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.dto.UserInfoRolesResponse;
import com.example.online_toy_store.dto.UserInfoUpdateRolesDto;
import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.exception.UserDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.mapper.UpdateRolesMapper;
import com.example.online_toy_store.repository.UserInfoRepository;
import com.example.online_toy_store.service.interf.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UpdateRolesMapper updateRolesMapper;

    @Override
    public List<UserInfo> showAll() {
        return userInfoRepository.findAll();
    }

    @Override
    @Transactional
    public UserInfoRolesResponse updateUserInfo(String uiId, UserInfoUpdateRolesDto userInfoUpdateRolesDto) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(UUID.fromString(uiId));
        UserInfo userInfoChecked;
        if (userInfoOptional.isEmpty())
            throw new UserDoesNotExistException("User does not exist");
        else userInfoChecked = userInfoOptional.get();
        UserInfo userInfo = updateRolesMapper.toEntity(uiId, userInfoUpdateRolesDto);
        userInfoChecked.setRoles(userInfo.getRoles());
        return updateRolesMapper.toDto(userInfoRepository.saveAndFlush(userInfoChecked));
    }

    @Override
    public UserInfo showUserInfo(String id) {
        return userInfoRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserDoesNotExistException(ErrorMessage.USER_DOES_NOT_EXIST));
    }

    @Override
    public UserInfo showByUserName(String name) {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findByUserName(name);
        if (optionalUserInfo.isEmpty()){
            throw new UserDoesNotExistException(ErrorMessage.USER_DOES_NOT_EXIST);
        }
        return optionalUserInfo.get();
    }
}
