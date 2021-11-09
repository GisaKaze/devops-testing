package com.example.devopstesting.service;

import com.example.devopstesting.dto.ShoppingCartDTO;
import com.example.devopstesting.model.Product;
import com.example.devopstesting.model.ShoppingCart;
import com.example.devopstesting.repository.ShoppingCartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingCartServiceTest {
  @Mock
   private ShoppingCartRepository shoppingCartRepository;
  @InjectMocks
   private ShoppingCartService shoppingCartService;

  @Test
  public void getShoppingCartProducts() {
      Product product = new Product(1L,"Lebron 19","The King's show a laker",12,130.02);
      when(shoppingCartRepository.findAll()).thenReturn(Arrays.asList(new ShoppingCart(1L,product,1,10.0,"BOUGHT",new Date())));
      assertEquals(1, shoppingCartService.findAll().size());
  }

  @Test
 public void saveToShoppingCart(){
      ShoppingCartDTO shopingCartDto = new ShoppingCartDTO(1L,1,"BOUGHT");
      when(shoppingCartRepository.save()).thenReturn(shopingCartDto);
      assertEquals(shopingCartDto,shoppingCartService.saveProducts(shopingCartDto));
  }

  @Test
 public void deleteFromShoppingCart(){
      ShoppingCartDTO shopingCartDto = new ShoppingCartDTO(1L,1,"BOUGHT");
      shoppingCartService.deleteProduct(1L);
      verify(shoppingCartRepository,times(1)).delete(1L);
  }

}
