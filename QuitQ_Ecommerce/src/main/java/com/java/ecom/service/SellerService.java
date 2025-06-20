package com.java.ecom.service;

import com.java.ecom.model.Product;
import com.java.ecom.model.Seller;
import com.java.ecom.repository.ProductRepository;
import com.java.ecom.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    // Add new product
    public Product addProduct(Integer sellerId, Product product) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        product.setSeller(seller);
        return productRepository.save(product);
    }

    // Get all products by seller
    public List<Product> getProductsBySellerId(Integer sellerId) {
        return productRepository.findBySeller_SellerId(sellerId);
    }

    // Update product
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
