package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserCreatedDto;
import com.example.online_toy_store.entity.Role;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.entity.enums.City;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface CreateUserMapper {
    @Mappings({
            @Mapping(target = "UID", ignore = true),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "country", source = "country"),
            @Mapping(target = "userInfo", ignore = true),
            @Mapping(target = "userOrders", ignore = true),
            @Mapping(target = "userReviews", ignore = true)
    })
    User toEntity(UserBeforeCreatingDto userBeforeCreatingDto);

    @AfterMapping
    default void generateUser(@MappingTarget User user, UserBeforeCreatingDto userBeforeCreatingDto){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userBeforeCreatingDto.getUserName());
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userBeforeCreatingDto.getPassword()));
        userInfo.setAddress(userBeforeCreatingDto.getAddress());
        userInfo.setCity(City.valueOf(userBeforeCreatingDto.getCity()));
        userInfo.setPostalCode(userBeforeCreatingDto.getPostalCode());
        userInfo.setEmail(userBeforeCreatingDto.getEmail());
        userInfo.setCardNumber(userBeforeCreatingDto.getCardNumber());
        Role role = new Role();
        role.setRId(UUID.fromString("e8e47c95-84bb-4262-819f-7eace92d5b7b"));
        userInfo.setRoles(Set.of(role));
        user.setUserInfo(userInfo);
        user.setCreatedAt(LocalDateTime.now());
    }

    @Mappings({
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "country", source = "country"),
            @Mapping(target = "address", source = "userInfo.address"),
            @Mapping(target = "city", source = "userInfo.city"),
            @Mapping(target = "postalCode", source = "userInfo.postalCode"),
            @Mapping(target = "email", source = "userInfo.email"),
            @Mapping(target = "answer", ignore = true)
    })
    UserCreatedDto toDto(User user);

}
