package com.orchestrationdemo.orderservicems.controller;

import com.orchestrationdemo.orderservicems.entity.PurchaseOrder;
import com.orchestrationdemo.orderservicems.model.OrderRequest;
import com.orchestrationdemo.orderservicems.model.OrderResponse;
import com.orchestrationdemo.orderservicems.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Mono<PurchaseOrder> createOrder(@RequestBody Mono<OrderRequest> orderMono) {
        return orderMono.flatMap(orderService::createOrder);
    }

    @GetMapping("/all")
    public Flux<OrderResponse> getOrders() {
        return orderService.getAllOrder();
    }
}
