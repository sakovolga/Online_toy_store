package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.entity.enums.City;
import com.example.online_toy_store.entity.enums.Country;
import com.example.online_toy_store.utils.ExpectedData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
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
class SupplierControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "ivan_ivanov", password = "529", roles = "SUPER_MANAGER")

    void createSupplierPositiveTest() throws Exception {
        Supplier newSupplier = new Supplier();
        newSupplier.setSupplierName("Big toy factory");
        newSupplier.setPhone("+90897867565");
        newSupplier.setEmail("big@toyfactoyr.com");
        newSupplier.setCountry(Country.GERMANY);
        newSupplier.setCity(City.BREMEN);
        newSupplier.setAddress("Schnoorviertel, 32");
        newSupplier.setPostalCode("67543");

        String newSupplierJSON = objectMapper.writeValueAsString(newSupplier);

        mockMvc.perform(MockMvcRequestBuilders.post("/supplier/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newSupplierJSON));

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/supplier/showByName/Big toy factory"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String getJSON = mvcResult.getResponse().getContentAsString();
        Supplier getSupplier = objectMapper.readValue(getJSON, Supplier.class);

        Assertions.assertEquals(newSupplier.getSupplierName(), getSupplier.getSupplierName());
    }

    @Test
    @WithMockUser(username = "ivan_ivanov", password = "529", roles = "SUPER_MANAGER")
    void createSupplierTestWithException() throws Exception {
        Supplier newSupplier = new Supplier();
        newSupplier.setSupplierName("Johnson Enterprises Ltd.");

        String newSupplierJSON = objectMapper.writeValueAsString(newSupplier);

        mockMvc.perform(MockMvcRequestBuilders.post("/supplier/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newSupplierJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("{\"message\":\"A supplier with name Johnson Enterprises Ltd. already exists\",\"statusCode\":400}"));
    }

    @Test
    @WithMockUser(username = "ivan_ivanov", password = "529", roles = "SUPER_MANAGER")
    void showSupplierByNamePositiveTest() throws Exception {
        Supplier expectedSupplier = ExpectedData.returnSupplier();

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/supplier/showByName/Johnson Enterprises Ltd."))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String actualSupplierJSON = mvcResult.getResponse().getContentAsString();
        Supplier actualSupplier = objectMapper.readValue(actualSupplierJSON, Supplier.class);

        Assertions.assertEquals(expectedSupplier, actualSupplier);
    }

    @Test
    @WithMockUser(username = "ivan_ivanov", password = "529", roles = "SUPER_MANAGER")
    void showSupplierByNameTestWithException() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/supplier/showByName/Non-existent name"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Supplier not found with name: Non-existent name\",\"statusCode\":404}"));
    }
}