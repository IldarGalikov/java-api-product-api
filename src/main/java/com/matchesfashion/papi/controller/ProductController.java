package com.matchesfashion.papi.controller;

import com.matchesfashion.papi.domain.Product;
import com.matchesfashion.papi.repository.ProductRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

  private final ProductRepository productReposity;

  public ProductController(ProductRepository productReposity) {
    this.productReposity = productReposity;
  }

  @GetMapping
  public List<Product> getAllProducts(){
    return productReposity.findAll();
  }
}
