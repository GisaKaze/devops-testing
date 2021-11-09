package com.example.devopstesting.repository;

import com.example.devopstesting.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    List<Product> findByName(String name);

   List<Product> findOne(Long id);
}
