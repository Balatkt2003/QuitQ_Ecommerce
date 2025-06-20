package com.java.ecom.controller;

import com.java.ecom.model.Admin;
import com.java.ecom.model.Product;
import com.java.ecom.model.User;
import com.java.ecom.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin login
    @PostMapping("/login")
    public Optional<Admin> login(@RequestParam String email, @RequestParam String password) {
        return adminService.login(email, password);
    }

    // View all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // Delete a user
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        adminService.deleteUser(userId);
        return "User deleted successfully.";
    }

    // View all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return adminService.getAllProducts();
    }

    // Delete a product
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        adminService.deleteProduct(productId);
        return "Product deleted successfully.";
    }
}
