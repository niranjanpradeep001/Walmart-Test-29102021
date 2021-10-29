package com.walmart.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.walmart.test.service.TestService;

@SpringBootApplication
@EnableScheduling
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
		TestService service =new TestService();
		service.readJob();
		service.processJob();
		service.writeJob();
		service.createReportJob();
	}

}
