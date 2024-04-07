package com.example.kafkaconnectexample.dao.repository;

import com.example.kafkaconnectexample.dao.entity.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            SELECT order FROM Order order
            WHERE order.id = :orderId AND order.isDeleted = false
            """)
    Optional<Order> findOrderById(Long orderId);


}
