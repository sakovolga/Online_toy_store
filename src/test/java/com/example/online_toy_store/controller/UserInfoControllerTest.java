package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.UserInfo;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
public class UserInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateUserInfoRolesPositiveTest() throws Exception {
        String id = "08ae72f7-4d3b-4fb1-bb0b-1aaae6b4a8ed";
        String requestBody = "{\"isCustomer\" : true, \"isManager\" : true, \"isSuper_manager\" : true, \"isAdmin\" : false}";

        MvcResult before = mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/getUserInfo/" + id))
                .andReturn();

        String responseBefore = before.getResponse().getContentAsString();
        UserInfo userInfoBefore = objectMapper.readValue(responseBefore, UserInfo.class);

        mockMvc.perform(MockMvcRequestBuilders.put("/userInfo/updateRoles/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        MvcResult after = mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/getUserInfo/" + id))
                .andReturn();

        String responseAfter = after.getResponse().getContentAsString();
        UserInfo userInfoAfter = objectMapper.readValue(responseAfter, UserInfo.class);

        Assertions.assertEquals(userInfoBefore.getRoles().size() + 2, userInfoAfter.getRoles().size());
    }

    @Test
    void updateUserInfoRolesTestExc404() throws Exception{
        String nonExistId = "08ae72f7-4d3b-4fb1-bb0b-1aaae6b4a8e1";
        String requestBody = "{\"isCustomer\" : true, \"isManager\" : true, \"isSuper_manager\" : true, \"isAdmin\" : false}";

        mockMvc.perform(MockMvcRequestBuilders.put("/userInfo/updateRoles/" + nonExistId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
