package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.entity.Product;
import com.example.online_toy_store.entity.PromoCode;
import com.example.online_toy_store.service.interf.PromoCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promo")
@RequiredArgsConstructor
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @Operation(
            summary = "Show promo code by name",
            description = "Retrieve a promo code by its unique name",
            tags = {"PROMO_CODE"},
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "The promo code name",
                            required = true,
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string", format = "String")
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Promo code found and returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PromoCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Promo code not found"
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
    public PromoCode showPromoCodeByName(@PathVariable(name = "name") String name) {
        return promoCodeService.showByName(name);
    }

    @Operation(
            summary = "Create new promo code",
            description = "Create new promo code and return it",
            tags = {"PROMO_CODE"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "The promo code to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PromoCode.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The promo code created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PromoCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The promo code already exist",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PromoCode.class)
                            )
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @PostMapping("/new")
    public PromoCode createPromoCode(@RequestBody PromoCode promoCode){
        return promoCodeService.createPromoCode(promoCode);
    }


    @Operation(
            summary = "Show all promo codes",
            description = "Get a list of all existing promo codes",
            tags = {"PROMO_CODE"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "All promo codes received",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PromoCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "200",
                            description = "No promo codes found"
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @GetMapping("/showAll")
    public List<PromoCode> showAllPromoCodes(){
        return promoCodeService.showAllPromoCodes();
    }


    @Operation(
            summary = "Show all promo codes by discount amount",
            description = "Get a list of promo codes with particular discount amount",
            tags = {"PROMO_CODE"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Required promo codes received",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PromoCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "200",
                            description = "No promo codes found"
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @GetMapping("/showAllByDiscount/{discount}")
    public List<PromoCode> showAllPromoCodesByDiscount(@PathVariable(name = "discount") double discount){
        return promoCodeService.showAllPromoCodesByDiscount(discount);
    }

    @Operation(
            summary = "Delete promo code by name",
            description = "Delete an existing order by its unique name",
            tags = {"PROMO_CODE"},
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "The unique promo code name",
                            required = true,
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string", format = "String")
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The promo code deleted"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "The promo code does not exist"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The promo code cannot be deleted because other objects reference it"
                    ),
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @DeleteMapping("/delete/{name}")
    public String deletePromoCodeByName(@PathVariable(name = "name") String name){
        return promoCodeService.deletePromoCodeByName(name);
    }
}
