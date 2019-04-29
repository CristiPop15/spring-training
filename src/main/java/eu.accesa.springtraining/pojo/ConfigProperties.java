package eu.accesa.springtraining.pojo;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties()
public class ConfigProperties {

  private Credentials credentials;
  private Server server;
  private Training training;
  private List<String> defaultRecipients;
  private Map<String, Boolean> additionalHeaders;

  public Map<String, Boolean> getAdditionalHeaders() {
    return additionalHeaders;
  }

  public List<String> getDefaultRecipients() {
    return defaultRecipients;
  }

  public Training getTraining() {
    return training;
  }

  public Server getServer() {
    return server;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public void setCredentials(Credentials credentials) {
    this.credentials = credentials;
  }

  public void setServer(Server server) {
    this.server = server;
  }

  public void setTraining(Training training) {
    this.training = training;
  }

  public void setDefaultRecipients(List<String> defaultRecipients) {
    this.defaultRecipients = defaultRecipients;
  }

  public void setAdditionalHeaders(Map<String, Boolean> additionalHeaders) {
    this.additionalHeaders = additionalHeaders;
  }
}
