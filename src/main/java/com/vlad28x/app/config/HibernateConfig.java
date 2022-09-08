package com.vlad28x.app.config;

import com.vlad28x.app.entity.Customer;
import com.vlad28x.app.entity.Employee;
import com.vlad28x.app.entity.Project;
import com.vlad28x.app.entity.User;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@PropertySource("classpath:/database.properties")
public class HibernateConfig {

    private final Environment env;

    public HibernateConfig(Environment env) {
        this.env = env;
    }

    @Bean
    EntityManagerFactory entityManagerFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addProperties(hibernateProperties());
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        return configuration.buildSessionFactory();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", env.getProperty("hibernate.connection.driver_class"));
        properties.setProperty("hibernate.connection.url", env.getProperty("hibernate.connection.url"));
        properties.setProperty("hibernate.connection.username", env.getProperty("hibernate.connection.username"));
        properties.setProperty("hibernate.connection.password", env.getProperty("hibernate.connection.password"));
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql", "false"));
        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql", "false"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "none"));
        return properties;
    }

}
