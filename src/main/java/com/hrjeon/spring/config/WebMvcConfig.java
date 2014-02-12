package com.hrjeon.spring.config;

import com.hrjeon.spring.interceptor.AttributeInterceptor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.support.OpenSessionInViewInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.hrjeon")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new MappingJackson2HttpMessageConverter());
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    try {
      registry.addWebRequestInterceptor(this.openSessionInViewInterceptor()).addPathPatterns("/**").excludePathPatterns("/resources/**");
      registry.addWebRequestInterceptor(new AttributeInterceptor()).addPathPatterns("/**").excludePathPatterns("/resources/**");
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  @Bean
  public OpenSessionInViewInterceptor openSessionInViewInterceptor() throws Exception {
    OpenSessionInViewInterceptor openSessionInViewInterceptor = new OpenSessionInViewInterceptor();
    openSessionInViewInterceptor.setSessionFactory(sessionFactory().getObject());

    return openSessionInViewInterceptor;
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/views");
    viewResolver.setSuffix(".jsp");
    viewResolver.setContentType("text/html; charset=UTF-8");

    return viewResolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setCompleteAutoload(true);

    return tilesConfigurer;
  }

  @Bean(name = "dataSource")
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
  }

  @Bean(name = "sessionFactory")
  public FactoryBean<SessionFactory> sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan("com.hrjeon");

    return sessionFactoryBean;
  }

  @Bean(name = "transactionManager")
  public HibernateTransactionManager transactionManager() throws Exception {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setDataSource(dataSource());
    transactionManager.setSessionFactory(sessionFactory().getObject());

    return transactionManager;
  }
}
