package com.retail.demo.controller;

import com.retail.demo.entity.OrderEntity;
import com.retail.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderResource {



    @Autowired
    private OrderService orderService;







    @GetMapping("/orders")
    // @EmployeeSecurity
    public List<OrderEntity> getAllOrders() {

        return orderService.getAllOrders();
    }


    @PostMapping("/order")
    public OrderEntity createOrder(@RequestBody OrderEntity order) throws URISyntaxException {



        OrderEntity result = orderService.create(order);

        return result;
    }


}
