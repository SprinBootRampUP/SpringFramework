package org.example.rampup.Configuration;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example.rampup")
public class AppConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/course");
        return driverManagerDataSource;

    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean localEMFB = new LocalContainerEntityManagerFactoryBean();
        localEMFB.setDataSource(dataSource);
        localEMFB.setPackagesToScan("org.example.rampup.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        localEMFB.setJpaVendorAdapter(vendorAdapter);

        //  Properties jpaproperties = new Properties();
        //  jpaproperties.put();

        return localEMFB;
    }

@Bean
    public JpaTransactionManager transactionManager (EntityManagerFactory  entityManagerFactory){
        return  new JpaTransactionManager(entityManagerFactory);
    }

}