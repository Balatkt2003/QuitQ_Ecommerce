package com.java.ecom.controller;

import com.java.ecom.model.Order;
import com.java.ecom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/seller/orders")
public class OrderController {

    @Autowired
    private OrderService sellerOrderService;

    // View all orders for a seller
    @GetMapping("/{sellerId}")
    public List<Order> getOrders(@PathVariable Integer sellerId) {
        return sellerOrderService.getOrdersBySeller(sellerId);
    }

    // Update status of an order
    @PutMapping("/{orderId}/status")
    public Order updateStatus(@PathVariable Integer orderId, @RequestParam String status) {
        return sellerOrderService.updateOrderStatus(orderId, status);
    }

    // Get total sales report
    @GetMapping("/{sellerId}/sales")
    public BigDecimal getSales(@PathVariable Integer sellerId) {
        return sellerOrderService.getTotalSales(sellerId);
    }
}
