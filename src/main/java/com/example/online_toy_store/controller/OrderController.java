package com.example.online_toy_store.controller;

import com.example.online_toy_store.entity.Order;
import com.example.online_toy_store.service.interf.OrderService;
import com.example.online_toy_store.validation.UuidChecker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @Operation(
            summary = "Show order by ID",
            description = "Retrieve an order by its unique identifier",
            tags = {"ORDER"},
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique identifier of the order",
                            required = true,
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string", format = "uuid")
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Order found and returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Order.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Order not found"
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
    @GetMapping("/showOrder/{id}")
    public Order showOrderById(@PathVariable(name = "id") @UuidChecker String id){
        return orderService.showOrder(id);
    }

    @Operation(
            summary = "Show all orders",
            description = "Get a list of all existing orders in all statuses",
            tags = {"ORDER"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "All orders received",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Order.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "No orders found"
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @GetMapping("/showAllOrders")
    public List<Order> showAllOrders(){
        return orderService.showAllOrders();
    }

    @Operation(
            summary = "Create new order",
            description = "Create new order and return the order",
            tags = {"ORDER"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "The order to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Order.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The order created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Order.class)
                            )
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @Operation(
            summary = "Delete order by ID",
            description = "Delete an existing order by its unique identifier",
            tags = {"ORDER"},
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique identifier of the order",
                            required = true,
                            in = ParameterIn.PATH,
                            schema = @Schema(type = "string", format = "uuid")
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The order deleted"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "The order does not exist"
                    )
            },
            security = {
                    @SecurityRequirement(name = "safety requirements")
            }
    )
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(@PathVariable(name = "id") String id){
       return orderService.deleteOrder(id);
    }

}
