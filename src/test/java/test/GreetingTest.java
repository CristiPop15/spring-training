package test;

import static org.hamcrest.Matchers.containsString;

import eu.accesa.springtraining.db.PriceHandler;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingTest {

  @MockBean
  PriceHandler priceHandler;

  @LocalServerPort
  int port;

  @Before
  public void setUp() {
    RestAssured.port = this.port;
  }

  @Test
  public void testGreetings() {
    get("/greeting")
        .then()
        .body(containsString("Hello"));

  }
}
