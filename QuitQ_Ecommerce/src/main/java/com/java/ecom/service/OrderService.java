package com.java.ecom.service;

import com.java.ecom.model.Order;
import com.java.ecom.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // View all orders for a seller
    public List<Order> getOrdersBySeller(Integer sellerId) {
        return orderRepository.findOrdersBySellerId(sellerId);
    }

    // Update order status
    public Order updateOrderStatus(Integer orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    // Get total sales amount
    public BigDecimal getTotalSales(Integer sellerId) {
        BigDecimal sales = orderRepository.getTotalSalesBySellerId(sellerId);
        return sales != null ? sales : BigDecimal.ZERO;
    }
}
