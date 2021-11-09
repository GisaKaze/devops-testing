package com.example.devopstesting.service;


import com.example.devopstesting.dto.ShoppingCartDTO;
import com.example.devopstesting.model.Product;
import com.example.devopstesting.model.ShoppingCart;
import com.example.devopstesting.repository.ProductRepository;

import com.example.devopstesting.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {
    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart saveProducts(ShoppingCartDTO shoppingCartDTO){
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = (Product) productRepository.findOne(shoppingCartDTO.getProductId());
        shoppingCart.setProduct(product);
        shoppingCart.setStatus(shoppingCartDTO.getStatus());
        shoppingCart.setDate(new Date());
        shoppingCart.setStock(shoppingCartDTO.getStock());
        shoppingCart.setAmount(product.getUnitPrice() * shoppingCartDTO.getStock());

        return shoppingCartRepository.save(shoppingCart);
    }


    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
//        return shoppingCartRepository.findByStatus("NOT_PURCHASED");
    }

    public ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, Long id) {
        ShoppingCart updateItem = (ShoppingCart) shoppingCartRepository.findOne(id);
        updateItem.setStock(shoppingCartDTO.getStock());
        updateItem.setAmount(updateItem.getProduct().getUnitPrice() * shoppingCartDTO.getStock());
        return shoppingCartRepository.save(updateItem);
    }

    public void deleteProduct(Long id) {
        shoppingCartRepository.delete(id);
    }

    public void clearShoppingCart() {
        shoppingCartRepository.deleteAll();
    }


    public List<ShoppingCart> findByPurchased() {
        return shoppingCartRepository.findByStatus("BOUGHT");
    }


    public void purchaseProducts(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart) shoppingCartRepository.findOne(id);
        shoppingCart.setStatus("BOUGHT");
        shoppingCartRepository.save(shoppingCart);
    }
}
