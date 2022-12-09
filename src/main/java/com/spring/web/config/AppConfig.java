package com.spring.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.spring.web.dao.IssueDAO;
import com.spring.web.dao.IssueDAOImpl;
import com.spring.web.dao.UserDAO;
import com.spring.web.dao.UserDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.spring.web" })
@PropertySource("classpath:database.properties")
public class AppConfig {
	
	private final String DATABASE_URL = "database.mysql.url";
	private final String DATABASE_DRIVER = "database.mysql.driver";
	private final String DATABASE_USERNAME = "database.mysql.username";
	private final String DATABASE_PASSWORD = "database.mysql.password";
	
	@Autowired
	Environment environment;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(DATABASE_URL));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DATABASE_DRIVER));
		driverManagerDataSource.setUsername(environment.getProperty(DATABASE_USERNAME));
		driverManagerDataSource.setPassword(environment.getProperty(DATABASE_PASSWORD));
		
		return driverManagerDataSource;
	}
}