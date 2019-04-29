package eu.accesa.springtraining;

import eu.accesa.springtraining.pojo.ConfigProperties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestPostConstructor {

  private static Logger log = LoggerFactory.getLogger(TestPostConstructor.class);

  @Value("${training.val}")
  private String val;

  @Value("${training.test.enabled}")
  private boolean enabled;

  @Autowired
  private ConfigProperties configProperties;

  @Autowired
  private ApplicationContext applicationContext;

  @PostConstruct
  public void init() {
    applicationContext.getDisplayName();
    configProperties.getCredentials();
    if (enabled) {
      log.info(" A pornit acest bean ");
    } else {
      log.info(val);
    }
  }

  @PreDestroy
  public void destroy() {
    log.info(" destroy ");
  }
}
