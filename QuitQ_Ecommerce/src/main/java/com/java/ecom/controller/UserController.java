package com.java.ecom.controller;

import com.java.ecom.model.User;
import com.java.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register User
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    } 

    // Login User
    @PostMapping("/login")
    public Optional<User> login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    // Get All Users
    @GetMapping("/showUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "User deleted successfully.";
    }
}
