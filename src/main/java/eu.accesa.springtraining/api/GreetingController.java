package eu.accesa.springtraining.api;

import eu.accesa.springtraining.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  @Autowired
  private GreetingsService greetingsService;

  @GetMapping("/greetings")
  public String greetings() {
    return greetingsService.getGreeting();
  }
}
