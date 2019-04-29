package eu.accesa.springtraining.config;

import eu.accesa.springtraining.error.ErrorHandlerRest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

  @Bean
  @Qualifier("shortTimeout")
  public RestTemplate getRestTemplate() {
    return createRestTemplate(2000);
  }

  @Bean
  @Qualifier("longTimeout")
  public RestTemplate getLongRestTemplate() {
    return createRestTemplate(30000);
  }

  private RestTemplate createRestTemplate(int readTimeout) {
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("JWT", "A simple JWT"));
    RestTemplate restTemplate = new RestTemplate();


    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(5000);
    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(readTimeout);

    restTemplate.setInterceptors(interceptors);
    restTemplate.setErrorHandler(new ErrorHandlerRest());

    return restTemplate;
  }
}
