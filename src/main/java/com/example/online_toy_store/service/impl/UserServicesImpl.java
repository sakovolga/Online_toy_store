package com.example.online_toy_store.service.impl;

import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserCreatedDto;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.entity.enums.Country;
import com.example.online_toy_store.exception.ListIsEmptyException;
import com.example.online_toy_store.exception.UserDoesNotExistException;
import com.example.online_toy_store.exception.errorMessage.ErrorMessage;
import com.example.online_toy_store.mapper.CreateUserMapper;
import com.example.online_toy_store.mapper.GetTopUsersMapper;
import com.example.online_toy_store.repository.OrderRepository;
import com.example.online_toy_store.repository.UserRepository;
import com.example.online_toy_store.service.interf.UserServices;
import com.example.online_toy_store.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;
    private final GetTopUsersMapper getTopUsersMapper;
    private final CreateUserMapper createUserMapper;
    @Override
    @Transactional
    public User showUser(String id) {

        return userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserDoesNotExistException(ErrorMessage.USER_DOES_NOT_EXIST));
    }

    @Override
    @Transactional
    public UserReportDtoAfter getTopUsers(String month, String year, String country) {
        List<User> userList = userRepository.findAllByCountry(Country.valueOf(country));
        LocalDateTime startDate = mapperUtil.getFirstDayOfMonth(year, month);
        LocalDateTime finalDate = mapperUtil.getLastDayOfMonth(year, month);
        for(User user: userList){
            Set<Order> orderSet = orderRepository
                    .findAllByUserAndOrderDateAfterAndOrderDateBefore(user, startDate, finalDate);
            user.setUserOrders(orderSet);
        }
        userList.removeIf(user -> user.getUserOrders().isEmpty());
        if (userList.isEmpty()) throw new ListIsEmptyException("No users were found for your request");
        return getTopUsersMapper.generateReport(userList, month, year, country);
    }

    @Override
    public UserCreatedDto createUser(UserBeforeCreatingDto userBeforeCreatingDto) {
        User user = userRepository.saveAndFlush(createUserMapper.toEntity(userBeforeCreatingDto));
        return createUserMapper.toDto(user);
    }

    @Override
    public List<User> showAll() {
        return userRepository.findAll();
    }


}
