package com.visa.prj.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	// configure datasource
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/hotel_db?createDatabaseIfNotExist=true");
			ds.setUsername("visa");
			ds.setPassword("secret");
		return ds;
	}
	//configure EntityManagerFactory
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(DataSource ds) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			emf.setDataSource(ds);
			emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
			emf.setPackagesToScan("com.visa.prj.entity");
		Properties props = new Properties();
			props.setProperty("hibernate.show_sql", "true");
       		props.setProperty("hibernate.format_sql", "true");
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			props.setProperty("hibernate.hbm2ddl.auto", "update") ; // create or update
			emf.setJpaProperties(props);
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
}












