package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.exception.UserDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.repository.UserRepository;
import com.example.online_toy_store.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    @Override
    @Transactional
    public User showUser(String id) {

        return userRepository.findById
                (UUID.fromString(id))
                .orElseThrow(() -> new UserDoesNotExistException(ErrorMessage.USER_DOES_NOT_EXIST));
    }
}
