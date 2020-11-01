package com.matchesfashion.papi;

import com.matchesfashion.papi.controller.ProductController;
import com.matchesfashion.papi.domain.Product;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = PapiApplication.class)
public class ProductControllerIT {

  @Autowired
  private ProductController productController;

  @Test
  public void getAllProductsReturnsValidProducts() {
    Assert.assertTrue(productController.getAllProducts(0).size() > 0);
  }

  @Test
  public void allProductsHavePositivePrice() {
    productController.getAllProducts(0).forEach(
        product -> Assert.assertTrue(product.getPrice() > 0)
    );
  }

  @Test
  public void getProductsWithPriceOver100() {
    List<Product> products = productController.getAllProducts(100);
    products.forEach( product -> Assert.assertTrue(product.getPrice() >= 100));
    Assert.assertEquals(products.size(), 2);
  }

}
