package com.java.ecom.repository;

import com.java.ecom.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Optional<Seller> findByEmail(String email);
    boolean existsByEmail(String email);
}
