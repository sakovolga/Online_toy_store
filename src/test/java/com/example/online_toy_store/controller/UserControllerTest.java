package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Authority;
import com.example.online_toy_store.entity.Role;
import com.example.online_toy_store.entity.User;
import com.example.online_toy_store.utils.ExpectedData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

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
                .andExpect(content().json("{\"message\":\"User does not exist\",\"statusCode\":404}"))
                .andReturn();
    }
}
