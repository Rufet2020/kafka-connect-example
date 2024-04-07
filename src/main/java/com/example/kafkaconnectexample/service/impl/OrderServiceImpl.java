package com.example.kafkaconnectexample.service.impl;

import com.example.kafkaconnectexample.dao.repository.OrderRepository;
import com.example.kafkaconnectexample.exception.OrderNotFoundException;
import com.example.kafkaconnectexample.mapper.OrderMapper;
import com.example.kafkaconnectexample.order.OrderDto;
import com.example.kafkaconnectexample.order.request.CreateOrderRequest;
import com.example.kafkaconnectexample.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(CreateOrderRequest request) {
        return orderMapper.toOrderDto(orderRepository.save(orderMapper.toOrderEntity(request)));
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        return orderRepository.findOrderById(orderId).map(orderMapper::toOrderDto)
                .orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().parallelStream().map(orderMapper::toOrderDto).toList();
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

}
