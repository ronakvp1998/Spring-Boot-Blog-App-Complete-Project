package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringbootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTransactionApplication.class, args);
	}

}
