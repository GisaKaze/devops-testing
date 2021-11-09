package com.example.devopstesting.service;

import com.example.devopstesting.model.Product;
import com.example.devopstesting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product addProduct(Product user) {
        return productRepository.save(user);
    }

    public List<Product> findAll() {
        List<Product> users = productRepository.findAll();
        return users;
    }

    public List<Product> getProductbyName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Product user) {
        productRepository.delete(user);
    }
}
