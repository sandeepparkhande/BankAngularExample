package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.data"})
@EntityScan(basePackages={"com.domain"})
public class BankRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankRestWebServiceApplication.class, args);
	}
}
