package com.hrjeon;

import com.hrjeon.spring.servlet.WebAppInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

public class WebServer {

  public void run() throws Exception {

    Server server = new Server(8080);

    WebAppContext webapp = new WebAppContext();
    webapp.setMaxFormContentSize(10000000);
    webapp.setInitParameter("spring.profiles.active", "dev");
    webapp.setResourceBase("src/main/webapp");
    webapp.setContextPath("/");
    webapp.setParentLoaderPriority(true);

    webapp.addEventListener(new ServletContextListener() {
      @Override
      public void contextInitialized(ServletContextEvent sce) {
        try {
          new WebAppInitializer().onStartup(sce.getServletContext());
        } catch (ServletException e) {
          throw new RuntimeException(e);
        }
      }

      @Override
      public void contextDestroyed(ServletContextEvent sce) {

      }
    });

    server.setHandler(webapp);

    server.start();
    server.join();
  }

  public static void main(String[] args) throws Exception {
    new WebServer().run();
  }
}