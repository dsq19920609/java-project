package com.testdubbo.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.testdubbo.offer")
public class CmpOfferBootstarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmpOfferBootstarterApplication.class, args);
	}

}
