package com.java.ecom.service;

import com.java.ecom.model.Admin;
import com.java.ecom.model.Product;
import com.java.ecom.model.User;
import com.java.ecom.repository.AdminRepository;
import com.java.ecom.repository.ProductRepository;
import com.java.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // Admin login
    public Optional<Admin> login(String email, String password) {
        return adminRepository.findByEmail(email)
                .filter(admin -> admin.getPassword().equals(password));
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Delete user
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Delete product
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
