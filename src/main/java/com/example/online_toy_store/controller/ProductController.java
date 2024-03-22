package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/showProduct/{id}")
    public Product showUserById(@PathVariable(name = "id") String id){
        return productService.showProduct(id);
    }

    @GetMapping("/showAllProducts")
    public List<Product> showAllProducts(){
        return productService.showProducts();
    }
}
