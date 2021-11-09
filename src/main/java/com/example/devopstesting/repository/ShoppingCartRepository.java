package com.example.devopstesting.repository;

import com.example.devopstesting.model.Product;
import com.example.devopstesting.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByStatus(String status);
    List<ShoppingCart> findOne(Long id);

    void delete(Long id);

    Object save();
}
