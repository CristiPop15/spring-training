package eu.accesa.springtraining.service;

import eu.accesa.springtraining.model.Price;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

  @Autowired
      @Qualifier("longTimeout")
  RestTemplate restTemplate;

  @Autowired
  PriceService priceService;

  @PostConstruct
  public void init() {
//    String response = restTemplate.getForObject("http://10.115.29.122:7070/greeting", String.class);
//    System.out.println(response + " ----- response from Attila");

  }
}
