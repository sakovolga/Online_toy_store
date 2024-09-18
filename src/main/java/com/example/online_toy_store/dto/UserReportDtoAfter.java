package com.example.online_toy_store.dto;

import java.util.List;

public class UserReportDtoAfter {
    String answer;
    List<UserDto> userDtoList;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<UserDto> getUserDtoList() {
        return userDtoList;
    }

    public void setUserDtoList(List<UserDto> userDtoList) {
        this.userDtoList = userDtoList;
    }
}
