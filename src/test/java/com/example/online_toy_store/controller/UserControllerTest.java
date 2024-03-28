package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.*;
import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.entity.enums.Country;
import com.example.online_toy_store.exception.UserDoesNotExistException;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
//@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop-tables.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showUserTestPositive() throws Exception {

        User user = new User();
        user.setUID(UUID.fromString("1b4a432d-1ec9-4141-ace1-1d6ed2e3de0f"));
        user.setFirstName("Julija");
        user.setLastName("Klimenko");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2024-01-07 12:20:49", formatter);
        user.setCreatedAt(dateTime);
        user.setCountry(Country.GERMANY);

        UserInfo userInfo = new UserInfo();
        userInfo.setUID(UUID.fromString("c9fb87a6-b0ff-457b-a646-6b4a2a107396"));
        userInfo.setUserName("julija_klimenko");
        userInfo.setAddress("Rosenweg 7");
        userInfo.setCity(City.DREZDEN);
        userInfo.setPostalCode("32546");
        userInfo.setEmail("klim@gmail.com");
        userInfo.setPassword("765000!fdbvytr");
        userInfo.setCardNumber("3463 8895 2271 479");
        user.setUserInfo(userInfo);

        Role role1 = new Role();
        role1.setRId(UUID.fromString("e8e47c95-84bb-4262-819f-7eace92d5b7b"));
        role1.setRoleName("customer");
        Set<Role> roleSet = Set.of(role1);
        userInfo.setRoles(roleSet);

        Authority authority1 = new Authority();
        authority1.setAId(UUID.fromString("1a10d548-3cf1-4c7c-9823-5e30cf273ad4"));
        authority1.setAuthorityName("Update customer profile");

        Authority authority2 = new Authority();
        authority2.setAId(UUID.fromString("a6d7c833-0fbf-4bdc-b07c-b3bbd3d8d708"));
        authority2.setAuthorityName("Place order");

        Authority authority3 = new Authority();
        authority3.setAId(UUID.fromString("b30fdaec-15f4-4df4-a2d4-cd4907f94a9a"));
        authority3.setAuthorityName("Create customer profile");

        Authority authority4 = new Authority();
        authority4.setAId(UUID.fromString("ff6b1bc1-1d0c-4f0f-b3e7-8be9ae76b986"));
        authority4.setAuthorityName("View own orders");

        Set<Authority> authoritySet = Set.of(authority1, authority2, authority3, authority4);
        role1.setAuthorities(authoritySet);

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
                .andExpect(content().string("User does not exist"))
                .andReturn();
    }
}
