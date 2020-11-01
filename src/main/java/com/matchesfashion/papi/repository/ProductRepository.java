package com.matchesfashion.papi.repository;

import com.matchesfashion.papi.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findByPriceGreaterThanEqual(Integer price);
}
