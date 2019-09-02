package com.chtrak.microsns.microsnsorder.controller;

import com.chtrak.microsns.microsnsorder.entity.Order;
import com.chtrak.microsns.microsnsorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping(value = "/order/{orderId}")
    public Order queryOrderById(@PathVariable(name="orderId") String orderId){
        return orderService.queryOrderById(orderId);
    }
}
