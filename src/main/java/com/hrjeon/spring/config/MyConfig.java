package com.hrjeon.spring.config;

import com.hrjeon.core.Lol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:/lol.properties"})
public class MyConfig {
  @Autowired
  Environment env;

  @Bean
  public Lol lol() {
    Lol lol = new Lol();
    lol.setApiKey(env.getProperty("lol.apiKey"));
    lol.setRegion(env.getProperty("lol.region"));

    return lol;
  }
}
