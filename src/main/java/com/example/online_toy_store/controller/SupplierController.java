package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CustomCreateSupplier;
import com.example.online_toy_store.annotation.CustomShowSupplierByName;
import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.service.interf.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @ResponseStatus(HttpStatus.CREATED)
    @CustomCreateSupplier(path = "/new")
    Supplier createSupplier(@RequestBody Supplier supplier){
       return supplierService.createSupplier(supplier);
    }

    @CustomShowSupplierByName(path = "/showByName/{name}")
    public Supplier showSupplierByName(@PathVariable(name = "name") String name){
        return supplierService.showByName(name);
    }
}
