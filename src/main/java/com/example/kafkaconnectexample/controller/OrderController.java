package com.example.kafkaconnectexample.controller;

import com.example.kafkaconnectexample.order.OrderDto;
import com.example.kafkaconnectexample.order.request.CreateOrderRequest;
import com.example.kafkaconnectexample.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderService service;

    @PostMapping()
    private ResponseEntity<OrderDto> createOrder(
            @RequestBody CreateOrderRequest request
    ) {
        return ResponseEntity.ok(service.createOrder(request));
    }

    @GetMapping("/all")
    private ResponseEntity<List<OrderDto>> getAll() {
        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/{id}")
    private ResponseEntity<OrderDto> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @DeleteMapping("/delete/{id}")
    private void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }

}
