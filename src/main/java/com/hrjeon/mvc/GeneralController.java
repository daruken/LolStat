package com.hrjeon.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dennis on 14. 2. 12.
 */
@Controller
public class GeneralController {
  @RequestMapping("/")
  public String index(@RequestParam(defaultValue = "") String name) {
    return name.isEmpty() ? "/index" : "redirect:/summoner/"+name;
  }
}
