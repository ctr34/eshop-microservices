package com.taoEshop.orderService.controller;

import com.taoEshop.orderService.dto.OrderRequest;
import com.taoEshop.orderService.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
         orderService.placeOrder(orderRequest);
         return "Order placed";
    }


}
