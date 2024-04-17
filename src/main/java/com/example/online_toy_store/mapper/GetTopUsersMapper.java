package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.UserDto;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface GetTopUsersMapper {

    default UserReportDtoAfter generateReport(List<User> userList, String month, String year, String country) {
        UserReportDtoAfter userReportDtoAfter = new UserReportDtoAfter();
        userReportDtoAfter.setAnswer("Top 3 buyers for the period: " + year + "-" + month + " from " + country);
        userReportDtoAfter.setUserDtoList(getTop3Users(mapToList(userList)));
        return userReportDtoAfter;
    }

    default List<UserDto> mapToList(List<User> userList){
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    default UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(String.valueOf(user.getUID()));
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setSum(getSum(user));
        return userDto;
    }

    default String getSum(User user){
        BigDecimal sum = user.getUserOrders()
                .stream()
                .map(order -> order.getOrderDetails()
                        .stream()
                        .map(orderDetail -> BigDecimal.valueOf(orderDetail.getQuantity())
                                .multiply(orderDetail.getProduct().getPrice()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return String.valueOf(sum.setScale(2, RoundingMode.HALF_UP));
    }

    default List<UserDto> getTop3Users(List<UserDto> userDtoList){
        return   userDtoList.stream()
                .sorted((o1, o2) -> Double.valueOf(o2.getSum()).compareTo(Double.valueOf(o1.getSum())))
                .limit(Math.min(3, userDtoList.size()))
                .collect(Collectors.toList());
    }
}
