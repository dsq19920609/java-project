package com.iwhalecloud.offer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.iwhalecloud.offer")
@EnableScheduling
@ServletComponentScan(basePackages = "com.iwhalecloud.offer.filter")
@MapperScan(basePackages = "com.iwhalecloud.offer.mapper")
public class OfferBootstarterApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OfferBootstarterApplication.class);
		app.run(args);
	}

}
