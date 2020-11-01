package com.matchesfashion.papi;


import com.matchesfashion.papi.domain.Product;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = PapiApplication.class)
public class ProductControllerIT {

  @LocalServerPort
  private Integer port;

  private String localhost;

  @Before
  public void setup(){
    localhost = "http://localhost:" + port;
  }


  @Test
  public void returns200WhenRequestingAllProducts() {
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    ResponseEntity<String> response = testRestTemplate.
        getForEntity(localhost + "/products", String.class);

    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void returns3ProductsWithEmptyQueryParameter() {
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    ResponseEntity<Product[]> response = testRestTemplate.
        getForEntity(localhost + "/products", Product[].class );

    Assert.assertEquals(3, response.getBody().length);
  }

  @Test
  public void returns2ProductsWithPriceQueryParameter100() {
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    ResponseEntity<Product[]> response = testRestTemplate.
        getForEntity(localhost + "/products?price=100", Product[].class );

    Assert.assertEquals(2, response.getBody().length);
  }

  @Test
  public void returns1ProductsWithPriceQueryParameter200() {
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    ResponseEntity<Product[]> response = testRestTemplate.
        getForEntity(localhost + "/products?price=200", Product[].class );
    Assert.assertEquals(1, response.getBody().length);
  }

  @Test
  public void returnsProductsWithPriceQueryParameter200() {
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    ResponseEntity<Product[]> response = testRestTemplate.
        getForEntity(localhost + "/products?price=200", Product[].class );
    Assert.assertEquals("Long Skirt", response.getBody()[0].getTitle());
  }
}
