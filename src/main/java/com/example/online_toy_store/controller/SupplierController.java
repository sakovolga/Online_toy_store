package com.example.online_toy_store.controller;

import com.example.online_toy_store.annotation.CreateSupplier;
import com.example.online_toy_store.annotation.ShowAllSuppliers;
import com.example.online_toy_store.annotation.ShowSupplierByName;
import com.example.online_toy_store.entity.Supplier;
import com.example.online_toy_store.service.interf.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @ResponseStatus(HttpStatus.CREATED)
    @CreateSupplier(path = "/new")
    Supplier createSupplier(@RequestBody Supplier supplier){
       return supplierService.createSupplier(supplier);
    }

    @ShowSupplierByName(path = "/showByName/{name}")
    public Supplier showSupplierByName(@PathVariable(name = "name") String name){
        return supplierService.showByName(name);
    }

    @ShowAllSuppliers(path = "/showAll")
    public List<Supplier> showAll(){
        return supplierService.showAll();
    }
}
