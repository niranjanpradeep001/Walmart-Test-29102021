package com.walmart.test.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;



public class TestService {
	
	
	public TestPOJO readJob() {
		RestTemplate rest = new RestTemplate();
		String URL = "https://whispering-temple-65255.herokuapp.com/xmlTelemetry";
		TestPOJO result = rest.getForObject(URL, TestPOJO.class);
		result.setTimestamp(new Date());
		return result;
	}
	
	
	public JSONObject processJob() {
		TestPOJO result = readJob();
		JSONObject json = new JSONObject();
		json.put("id", result.getId());
		json.put("temperature", result.getTemperature());
		json.put("humidity", result.getHumidity());
		json.put("location", result.getLocation());
		json.put("timestamp", result.getTimestamp());
		return json;
	}
	
	@Scheduled(initialDelay = 1000, fixedRate = 5*60*1000)
	public void writeJob() {
		JSONObject obj = processJob();
		try {
			File myObj = new File(Paths.get("").toAbsolutePath().toString()+"\\"+new Date().getTime());
			FileWriter file = new FileWriter(Paths.get("").toAbsolutePath().toString());
			file.write(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Scheduled(initialDelay = 1000, fixedRate = 10*60*1000)
	public void createReportJob() {
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(new FileReader(Paths.get("").toAbsolutePath().toString()));

			for (int i = 0; i < data.size(); i++) {
				if ((int) data.get("temperature") > 45) {
					createReport(data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}


	private void createReport(JSONObject data) {
		try {
			File myObj = new File(Paths.get("").toAbsolutePath().toString()+"\\ReportFile-"+new Date().getTime());
			FileWriter file = new FileWriter(Paths.get("").toAbsolutePath().toString());
			file.write(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
