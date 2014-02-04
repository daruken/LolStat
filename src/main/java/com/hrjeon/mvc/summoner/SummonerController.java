package com.hrjeon.mvc.summoner;

import com.hrjeon.db.Summoner;
import com.hrjeon.lol.LolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 14. 2. 4.
 */
@Controller
@RequestMapping("/summoner")
public class SummonerController {
  @Autowired
  private SummonerService service;

  @RequestMapping(value = "/summoner/search/{name}", method = RequestMethod.GET)
  public ModelAndView search(@PathVariable String name) throws IOException, LolException {
    return new ModelAndView("/index")
        .addObject("id", service.searchByName(name).getId());
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Summoner get(@PathVariable Long id) {
    return service.get(id);
  }

  @ExceptionHandler(LolException.class)
  @ResponseBody
  private Map<?, ?> error(LolException e) {
    Map<String, Object> results = new HashMap<String, Object>();
    results.put("responseCode", e.getResponseCode());
    results.put("errorMessage", e.getMessage());

    return results;
  }
}
