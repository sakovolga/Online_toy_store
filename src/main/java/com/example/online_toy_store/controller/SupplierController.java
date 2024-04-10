package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CreateSupplierMappingAndDocumentation;
import com.example.online_toy_store.annotation.ShowSupplierByNameMappingAndDocumentation;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.service.interf.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @ResponseStatus(HttpStatus.CREATED)
    @CreateSupplierMappingAndDocumentation(path = "/new")
    Supplier createSupplier(@RequestBody Supplier supplier){
       return supplierService.createSupplier(supplier);
    }

    @ShowSupplierByNameMappingAndDocumentation(path = "/showByName/{name}")
    public Supplier showSupplierByName(@PathVariable(name = "name") String name){
        return supplierService.showByName(name);
    }
}
