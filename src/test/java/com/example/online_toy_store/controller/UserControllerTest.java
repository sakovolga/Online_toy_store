package com.example.online_toy_store.controller;

import com.example.online_toy_store.dto.UserBeforeCreatingDto;
import com.example.online_toy_store.dto.UserCreatedDto;
import com.example.online_toy_store.dto.UserDto;
import com.example.online_toy_store.dto.UserReportDtoAfter;
import com.example.online_toy_store.entity.*;
import com.example.online_toy_store.utils.ExpectedData;
import com.example.online_toy_store.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showUserTestPositive() throws Exception {

        User user = ExpectedData.returnUser();

        MvcResult showUserResult =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/user/showUser/1b4a432d-1ec9-4141-ace1-1d6ed2e3de0f"))
                        .andExpect(status().isOk())
                        .andReturn();

        String userResultJSON = showUserResult.getResponse().getContentAsString();
        User userResult = objectMapper.readValue(userResultJSON, User.class);

        Assertions.assertEquals(user, userResult);
        Assertions.assertEquals(user.getUserInfo(), userResult.getUserInfo());
        Assertions.assertEquals(user.getUserInfo().getRoles(), userResult.getUserInfo().getRoles());

        Set<Authority> allAuthorities = new HashSet<>();
        for (Role role : user.getUserInfo().getRoles()) {
            allAuthorities.addAll(role.getAuthorities());
        }
        Set<Authority> allAuthoritiesResult = new HashSet<>();
        for (Role role : userResult.getUserInfo().getRoles()) {
            allAuthoritiesResult.addAll(role.getAuthorities());
        }
        Assertions.assertEquals(allAuthorities, allAuthoritiesResult);
    }

    @Test
    void showUserTestNegative() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/showUser/1b4a432d-1ec9-4141-ace1-1d6ed2e3de00"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"User does not exist\",\"statusCode\":404}"));
    }

    @Test
    void getTopUsersPositiveTest() throws Exception {
        List<UserDto> userDtoList = ExpectedData.returnReport();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/getReport/02/2024/GERMANY"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Top 3 buyers for the period:")))
                .andReturn();

        String userResultJSON = mvcResult.getResponse().getContentAsString();
        UserReportDtoAfter userReportDtoAfter = objectMapper.readValue(userResultJSON, UserReportDtoAfter.class);

        Assertions.assertEquals(userDtoList, userReportDtoAfter.getUserDtoList());
    }

    @ParameterizedTest
    @ValueSource(strings = {"/user/getReport/099/2024/GERMANY",
            "/user/getReport/02/yyyy/GERMANY",
            "/user/getReport/02/2024/NON-EXIST COUNTY"})
    void getTopUsersTestWithExc400(String path) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void CreateUserDtoPositiveTest() throws Exception {
        UserBeforeCreatingDto userBeforeCreatingDto = ExpectedData.returnUserBeforeCreatingDto();

        String json = objectMapper.writeValueAsString(userBeforeCreatingDto);

        Set<User> userSetBefore = showAll();

        mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Set<User> userSetAfter = showAll();
        Set<UserInfo> userInfoSet = showAllInfo();

        Assertions.assertEquals(userSetBefore.size() + 1, userSetAfter.size());
        boolean vasiaFound = false;
        UserInfo userInfoVasia = new UserInfo();
        for (UserInfo userInfo : userInfoSet) {
            if ("Vasia".equals(userInfo.getUserName())) {
                vasiaFound = true;
                userInfoVasia = userInfo;
            }
        }
        long count = userInfoVasia.getRoles().stream()
                .map(Role::getRoleName)
                .filter(roleName -> Objects.equals(roleName, "customer"))
                .count();
        Assertions.assertTrue(userInfoVasia.getRoles().size() == 1 && count == 1);

        Assertions.assertTrue(vasiaFound);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "testdata/userExistingEmail.json",
            "testdata/userExistingName.json",
            "testdata/userSkippedFields.json"
    })
    void UserCreatedDtoTestWithExc400(String filePath) throws Exception {
        String json = Utils.loadJsonFromFile(filePath);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    Set<User> showAll() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/showAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String userListJSON = mvcResult.getResponse().getContentAsString();
        return objectMapper.readValue(userListJSON, new TypeReference<Set<User>>() {
        });
    }

    Set<UserInfo> showAllInfo() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/showAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String userInfoListJSON = mvcResult.getResponse().getContentAsString();
        return objectMapper.readValue(userInfoListJSON, new TypeReference<Set<UserInfo>>() {
        });
    }
}