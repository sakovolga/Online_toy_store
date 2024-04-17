package com.example.online_toy_store.dto;

import lombok.Data;

import java.util.List;
@Data
public class UserReportDtoAfter {
    String answer;
    List<UserDto> userDtoList;
}
