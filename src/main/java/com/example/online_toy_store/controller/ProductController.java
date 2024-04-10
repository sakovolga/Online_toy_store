package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.GetAllProductsMappingAndDocumentation;
import com.example.online_toy_store.annotation.GetProductMappingAndDocumentation;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetProductMappingAndDocumentation(path = "/showProduct/{id}")
    public Product showProductById(@PathVariable(name = "id") String id){
        return productService.showProduct(id);

    }

    @GetAllProductsMappingAndDocumentation(path = "/showAllProducts")
    public List<Product> showAllProducts(){
        return productService.showProducts();
    }
}
