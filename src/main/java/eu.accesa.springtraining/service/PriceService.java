package eu.accesa.springtraining.service;

import eu.accesa.springtraining.db.PriceHandler;
import eu.accesa.springtraining.db.PriceMapper;
import eu.accesa.springtraining.model.Price;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

  @Autowired
  PriceMapper priceMapper;

  public void addPrice(Price price) {
    priceMapper.insertPrice(price);
  }

//  @Scheduled(initialDelay = 5000, fixedDelay = 300000)
  public void insertPrice() {
    Price price = new Price();
    price.setOutletId(466);
    price.setCurrency("RON");
    price.setProductId(1222);
    price.setLastUpdate(new Date());
    price.setSalesPrice(23.45);
    addPrice(price);
  }


//  @Scheduled(initialDelay = 6000, fixedDelay = 300000)
  public void select() {
    List<Price> prices = priceMapper.getAll();
    System.out.println(prices);
  }

  @Scheduled(initialDelay = 6000, fixedDelay = 300000)
  public void selectWithHandler() {
    priceMapper.select(new PriceHandler());
  }
}
