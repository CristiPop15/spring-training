package eu.accesa.springtraining.controller;

import eu.accesa.springtraining.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MVCController {

  @GetMapping("/login")
  public String getHomeTemplate(User user) {
    return "login";
  }

//  @PostMapping("/login")
//  public String login(@ModelAttribute User user) {
//    return "result";
//  }

  @GetMapping("/private")
  public String getPrivate() {
    return "secure";
  }
}
