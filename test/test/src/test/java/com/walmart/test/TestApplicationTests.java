package com.walmart.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.walmart.test.service.TestPOJO;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testReadJob() {
		 RestTemplate restTemplate = new RestTemplate();
	     
		    final String uri = "https://whispering-temple-65255.herokuapp.com/xmlTelemetry";
		   
		 
		    TestPOJO result = restTemplate.getForObject(uri, TestPOJO.class);
		     
		   
	}
}
