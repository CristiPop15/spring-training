package eu.accesa.springtraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "training.test.enabled", havingValue = "true")
public class TestScheduler {

  private static Logger log = LoggerFactory.getLogger(TestPostConstructor.class);

  @Value("${training.val}")
  private String val;

  @Scheduled(initialDelay = 500, fixedDelay = 1000)
  public void orice() {
    log.info("schedule start " + val);
  }

}
