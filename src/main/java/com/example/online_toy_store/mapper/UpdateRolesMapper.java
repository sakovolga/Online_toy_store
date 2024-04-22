package com.example.online_toy_store.mapper;

import com.example.online_toy_store.dto.UserInfoRolesResponse;
import com.example.online_toy_store.dto.UserInfoUpdateRolesDto;
import com.example.online_toy_store.entity.Role;
import com.example.online_toy_store.entity.UserInfo;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface UpdateRolesMapper {
    default UserInfo toEntity(String id, UserInfoUpdateRolesDto userInfoUpdateRolesDto){
        UserInfo userInfo = new UserInfo();
        userInfo.setUID(UUID.fromString(id));
        Set<Role> roleSet = new HashSet<>();
        Role customer = new Role();
        customer.setRId(UUID.fromString("e8e47c95-84bb-4262-819f-7eace92d5b7b"));
        Role manager = new Role();
        manager.setRId(UUID.fromString("1c7e315b-38e1-4e89-9b56-40c5098d3b8f"));
        Role super_manager = new Role();
        super_manager.setRId(UUID.fromString("ba26b7c5-08cb-46c5-bbf0-35203e269306"));
        Role admin = new Role();
        admin.setRId(UUID.fromString("2057a26e-3d3e-4e8e-84bc-d3b9002de4f3"));
        if (userInfoUpdateRolesDto.getIsCustomer()) roleSet.add(customer);
        if (userInfoUpdateRolesDto.getIsManager()) roleSet.add(manager);
        if (userInfoUpdateRolesDto.getIsSuper_manager()) roleSet.add(super_manager);
        if (userInfoUpdateRolesDto.getIsAdmin()) roleSet.add(admin);
        userInfo.setRoles(roleSet);
        return userInfo;
    }
    @Mappings({
            @Mapping(target = "answer", ignore = true),
            @Mapping(target = "UID",  source = "UID"),
            @Mapping(target = "userName", source = "userName"),
            @Mapping(target = "roles", source = "roles")
    })
    UserInfoRolesResponse toDto(UserInfo userInfo);
}
