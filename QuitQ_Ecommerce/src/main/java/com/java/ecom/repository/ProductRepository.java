package com.java.ecom.repository;

import com.java.ecom.model.Product;
import com.java.ecom.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Search by category
    List<Product> findByCategory(String category);

    // Search by product name (case-insensitive)
    List<Product> findByNameContainingIgnoreCase(String keyword);

    // ✅ Get products by seller entity
    List<Product> findBySeller(Seller seller);

    // ✅ Get products by seller ID (nested field access)
    List<Product> findBySeller_SellerId(Integer sellerId);
}
