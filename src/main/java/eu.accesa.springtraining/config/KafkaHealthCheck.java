package eu.accesa.springtraining.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

//@Component
public class KafkaHealthCheck extends AbstractHealthIndicator {

  @Override
  protected void doHealthCheck(Builder builder) throws Exception {
     builder.withDetail("testDown", "is passed").build();
  }
}
