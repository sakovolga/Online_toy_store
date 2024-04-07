package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CustomGetProduct;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.service.interf.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @CustomGetProduct(path = "/showProduct/{id}")
    public Product showProductById(@PathVariable(name = "id") String id){
        return productService.showProduct(id);
    }


    @Operation(
            summary = "Show all products",
            description = "Get a list of all existing products in all statuses",
            tags = {"PRODUCT"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "All products received",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "No products found"
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @GetMapping("/showAllProducts")
    public List<Product> showAllProducts(){
        return productService.showProducts();
    }
}
