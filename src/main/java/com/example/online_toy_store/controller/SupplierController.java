package com.example.online_toy_store.controller;

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

    @Operation(
            summary = "Create new supplier",
            description = "Create new supplier and return him",
            tags = {"SUPPLIER"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "The supplier to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Supplier.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The supplier created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Supplier.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The supplier already exist",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Supplier.class)
                            )
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    Supplier createSupplier(@RequestBody Supplier supplier){
       return supplierService.createSupplier(supplier);
    }


    @Operation(
            summary = "Show supplier by name",
            description = "Retrieve a supplier by its unique name",
            tags = {"SUPPLIER"},
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "The supplier name",
                            required = true,
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string", format = "String")
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Supplier found and returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Supplier.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Supplier not found"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid ID" //Спросить почему не показывает в браузере
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            },
            hidden = false
    )
    @GetMapping("/showByName/{name}")
    public Supplier showSupplierByName(@PathVariable(name = "name") String name){
        return supplierService.showByName(name);
    }

}
