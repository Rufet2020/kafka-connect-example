package com.example.kafkaconnectexample.service;


import com.example.kafkaconnectexample.order.OrderDto;
import com.example.kafkaconnectexample.order.request.CreateOrderRequest;
import java.util.List;

public interface OrderService {

    OrderDto createOrder(CreateOrderRequest request);

    OrderDto getOrderById(Long orderId);

    List<OrderDto> getAllOrders();

    void deleteOrder(Long orderId);

}
