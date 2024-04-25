package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CreateProductDto;
import com.example.online_toy_store.annotation.GetAllProducts;
import com.example.online_toy_store.annotation.GetProduct;
import com.example.online_toy_store.dto.ProductAfterCreatingDto;
import com.example.online_toy_store.dto.ProductBeforeCreatingDto;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetProduct(path = "/showProduct/{id}")
    public Product showProductById(@PathVariable(name = "id") String id){
        return productService.showProduct(id);
    }

    @GetAllProducts(path = "/showAllProducts")
    public List<Product> showAllProducts(){
        return productService.showProducts();
    }

    @CreateProductDto(path = "/dto/create")
    public ProductAfterCreatingDto createProductDto(@RequestBody ProductBeforeCreatingDto productBeforeCreatingDto){
        return productService.createProductDto(productBeforeCreatingDto);
    }
}
