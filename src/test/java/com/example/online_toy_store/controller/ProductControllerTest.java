package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.utils.ExpectedData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop-tables.sql")
@Sql("/create-tables.sql")
@Sql("/insert_test_data.sql")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showProductTestPositive() throws Exception{
        Product expectedProduct = ExpectedData.returnProduct();

        MvcResult showProductResult =
                mockMvc
                        .perform(MockMvcRequestBuilders
                                .get("/product/showProduct/3b287f30-6c1c-4e71-b7bf-881e2d7b3cb4"))
                        .andExpect(status().isOk())
                        .andReturn();

        String productResultJSON = showProductResult.getResponse().getContentAsString();
        Product actualProduct = objectMapper.readValue(productResultJSON, Product.class);

        Assertions.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void showProductWithExceptionTest() throws Exception{
        String nonExistentID = "4eab43a7-0385-48f3-bfd3-4529a2bcfd52";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/showProduct/{id}", nonExistentID))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Product does not exist\",\"statusCode\":404}"));
    }

    @Test
    void showProductWithNotValidUUIDTest() throws Exception{
        String invalidUUID = "invalidUUID";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/showProduct/{id}", invalidUUID))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("{\"message\":\"Invalid UUID string: invalidUUID\",\"statusCode\":400}"));
    }

    @Test
    void showAllProductsTest () throws Exception{
        Set<Product> expectedProductSet = ExpectedData.returnAllProducts();

        Set<Product> actualProductSet = showAllProducts();
        Assertions.assertEquals(actualProductSet, expectedProductSet);
    }

    @Test
    void createProductDtoWithExistingSupplierTest() throws Exception {
        String ProductBeforeCreatingDtoJSON = "{\n" +
                "    \"name\" : \"Small doll\",\n" +
                "    \"description\" : \"Small beautifull doll\",\n" +
                "    \"price\" : \"56.9\",\n" +
                "    \"availableQuantity\" : \"10\",\n" +
                "    \"category\" : \"DOLLS\",\n" +
                "    \"supplierName\" : \"Johnson Enterprises Ltd.\",\n" +
                "    \"isAvailable\" : \"true\",\n" +
                "    \"address\" : \"14 Rue de la Republique\",\n" +
                "    \"city\" : \"LYON\",\n" +
                "    \"country\" : \"FRANCE\",\n" +
                "    \"email\" : \"je@nterprises.com\",\n" +
                "    \"phone\" : \"+33 1 23 45 67 89\",\n" +
                "    \"postal_code\" : \"12384\"\n" +
                "}";

        Set<Product> productSetBefore = showAllProducts();
//        Set<Supplier> supplierSetBefore =

        mockMvc.perform(MockMvcRequestBuilders.post("/product/dto/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ProductBeforeCreatingDtoJSON));

        Set<Product> productSetAfter = showAllProducts();

        Assertions.assertEquals(productSetBefore.size(), productSetAfter.size() - 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "testdata/productWithIncorrectCategory.json",
            "testdata/productWithIncorrectCity.json",
            "testdata/productWithIncorrectCountry.json"
    })
    void createProductDtoWithExceptionTest(String filePath) throws Exception{
        String json = loadJsonFromFile(filePath);

        mockMvc.perform(MockMvcRequestBuilders.post("/product/dto/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("does not exist!!! Please enter an existing")));
    }

    private String loadJsonFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(new ClassPathResource(filePath).getURI())));
    }

    Set<Product> showAllProducts() throws Exception {
        MvcResult showAllProductsResult =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/product/showAllProducts"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        String productsResultJSON = showAllProductsResult.getResponse().getContentAsString();
        return objectMapper.readValue(productsResultJSON, new TypeReference<Set<Product>>() {});
    }

}
