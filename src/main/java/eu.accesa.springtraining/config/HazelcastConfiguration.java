package eu.accesa.springtraining.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class HazelcastConfiguration {

  private static final Logger log = LoggerFactory.getLogger(HazelcastConfiguration.class);

//  @Bean
  public Config config() {

    System.setProperty("hazelcast.backpressure.enabled", "true");

    Config config = new Config();

    MaxSizeConfig msc = new MaxSizeConfig();
    msc.setMaxSizePolicy(MaxSizeConfig.MaxSizePolicy.PER_NODE);
    msc.setSize(2000);

    NetworkConfig networkConfig = config.getNetworkConfig();
    networkConfig.setPort(5701).setPortCount(20);
    networkConfig.setPortAutoIncrement(true);

    return config;
  }
}
