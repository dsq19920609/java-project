package com.testdubbo.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.testdubbo.cc")
public class CmpCcBootstarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmpCcBootstarterApplication.class, args);
	}

}
