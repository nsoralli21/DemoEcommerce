package com.demoEcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class DemoEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEcommerceApplication.class, args);
	}

}
