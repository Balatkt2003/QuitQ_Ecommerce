package com.java.ecom.controller;

import com.java.ecom.model.Product;
import com.java.ecom.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller/products")
public class SellerController {

    @Autowired
    private SellerService sellerProductService;

    // Add a new product
    @PostMapping("/{sellerId}")
    public Product addProduct(@PathVariable Integer sellerId, @RequestBody Product product) {
        return sellerProductService.addProduct(sellerId, product);
    }

    // Get all products of a seller
    @GetMapping("/{sellerId}")
    public List<Product> getSellerProducts(@PathVariable Integer sellerId) {
        return sellerProductService.getProductsBySellerId(sellerId);
    }

    // Update a product
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return sellerProductService.updateProduct(product);
    }

    // Delete a product
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        sellerProductService.deleteProduct(productId);
        return "Product deleted successfully.";
    }
}
