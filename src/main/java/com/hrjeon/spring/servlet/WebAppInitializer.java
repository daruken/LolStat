package com.hrjeon.spring.servlet;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by dennis on 14. 2. 3.
 */
public class WebAppInitializer extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.scan("com.hrjeon");

    return applicationContext;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[0];
  }

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    return null;
  }
}
