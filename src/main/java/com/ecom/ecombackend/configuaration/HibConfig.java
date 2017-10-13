package com.ecom.ecombackend.configuaration;




import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class HibConfig {
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
				dataSource.setDriverClassName("org.h2.Driver");
				dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecom");
				dataSource.setUsername("vai");
				dataSource.setPassword("vai");
				
				return dataSource;
	}
	
	//Bean Created Again
	@Bean
	public LocalSessionFactoryBuilder sessionFactory()
	{
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(dataSource());
		sessionFactory.scanPackages("com.ecom.ecombackend");
		sessionFactory.setProperties(hibernateProperties());
		return sessionFactory();
	}
	private Properties hibernateProperties()
	{
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.show_sql", "org.hibernate.SQL");
		return hibernateProperties;
	}
	

}
