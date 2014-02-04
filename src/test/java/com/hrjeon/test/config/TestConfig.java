package com.hrjeon.test.config;

import com.hrjeon.spring.servlet.WebAppInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by dennis on 14. 2. 4.
 */
@Configuration
@Profile("test")
public class TestConfig {
  @Bean
  public ServletContext servletContext() throws ServletException {
    ServletContext servletContext = new MockServletContext();

    return servletContext;
  }
}
