package com.java.ecom.repository;

import com.java.ecom.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Orders for seller
    @Query("SELECT o FROM Order o WHERE o.product.seller.sellerId = :sellerId")
    List<Order> findOrdersBySellerId(Integer sellerId);

    // Total revenue for seller
    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.product.seller.sellerId = :sellerId")
    BigDecimal getTotalSalesBySellerId(Integer sellerId);
}
