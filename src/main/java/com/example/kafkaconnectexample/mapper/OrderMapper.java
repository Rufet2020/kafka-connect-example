package com.example.kafkaconnectexample.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import com.example.kafkaconnectexample.dao.entity.Order;
import com.example.kafkaconnectexample.order.OrderDto;
import com.example.kafkaconnectexample.order.request.CreateOrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    Order toOrderEntity(CreateOrderRequest request);

}
