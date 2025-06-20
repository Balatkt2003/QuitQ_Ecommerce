package com.java.ecom.service;

import com.java.ecom.model.Product;
import com.java.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // Get products by category
    public List<Product> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Search products by name
    public List<Product> search(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    // Admin: Delete product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
