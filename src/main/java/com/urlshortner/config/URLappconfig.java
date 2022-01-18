package com.urlshortner.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "com.urlshortner" })
public class URLappconfig {

	@Bean
	public InternalResourceViewResolver ViewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/View/");
		view.setSuffix(".jsp");

		return view;
	}

	@Bean
	public JdbcTemplate dataconnect() {
		JdbcTemplate jdbc = new JdbcTemplate(datasource());

		return jdbc;
	}

	public DataSource datasource() {
		DriverManagerDataSource db = new DriverManagerDataSource();

		db.setUsername("root");
		db.setPassword("password");
		db.setDriverClassName("com.mysql.cj.jdbc.Driver");
		db.setUrl("jdbc:mysql://localhost:3306/URLShortner?useSSL=false");

		return db;

	}
}
