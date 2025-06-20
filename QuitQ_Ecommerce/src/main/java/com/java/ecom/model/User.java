package com.java.ecom.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String email;

    private String password;

    private String gender;

    private String mobile;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        buyer, seller, admin
    }
}
