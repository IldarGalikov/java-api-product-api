package com.matchesfashion.papi;

import com.matchesfashion.papi.controller.ProductController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = PapiApplication.class)
public class ProductTests {

  @Autowired
  private ProductController productController;

  @Test
  public void getAllProductsReturnsValidProducts() {
    Assert.assertTrue(productController.getAllProducts().size() > 0);
  }

}
