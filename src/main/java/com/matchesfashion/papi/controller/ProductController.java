package com.matchesfashion.papi.controller;

import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductRepository productReposity;


  @GetMapping
  public List<Product> getAllProducts(@RequestParam(required = false) Integer price){
    if (price == null || price < 0)
      price = 0;
    return productReposity.findByPriceGreaterThanEqual(price);
  }

}
