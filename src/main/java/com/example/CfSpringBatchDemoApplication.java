package com.example;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableBatchProcessing
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class CfSpringBatchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfSpringBatchDemoApplication.class, args);
	}

}
