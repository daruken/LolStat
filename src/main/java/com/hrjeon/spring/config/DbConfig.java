package com.hrjeon.spring.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DbConfig {

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
