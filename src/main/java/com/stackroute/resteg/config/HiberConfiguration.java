package com.stackroute.resteg.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stackroute.resteg.model.Customer;
import com.stackroute.resteg.model.Item;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages="com.stackroute.resteg")
public class HiberConfiguration {

	@Bean
	public DataSource getdatasource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/ustgcrud");
		datasource.setUsername("root");
		datasource.setPassword("password");
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean getsession(DataSource ds) throws IOException
	{
		
		LocalSessionFactoryBean localsession=new LocalSessionFactoryBean();
		
		localsession.setDataSource(ds); //
		
		
		Properties prop=new Properties();
		
		prop.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		prop.put("hibernate.hbm2ddl.auto","update");
		prop.put("hibernate.show_sql", "true");
		localsession.setHibernateProperties(prop);
	  	localsession.setAnnotatedClasses(Item.class);
		localsession.afterPropertiesSet();
		return localsession;
	}
	
	@Bean
	public HibernateTransactionManager gethibertransact(SessionFactory sessfact)
	{
		HibernateTransactionManager hibermanager=new HibernateTransactionManager();
		hibermanager.setSessionFactory(sessfact);
		return hibermanager;
		
	}
	
}
