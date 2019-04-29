package eu.accesa.springtraining.config;

import eu.accesa.springtraining.auth.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

  @Bean
  public FilterRegistrationBean registerExternalAuthFilter() {
    FilterRegistrationBean reg = new FilterRegistrationBean();
	  reg.setFilter(new AuthorizationFilter());
    reg.setName("authFilterExternal");
    reg.addUrlPatterns("/greetings/*");
    return reg;
  }
}
