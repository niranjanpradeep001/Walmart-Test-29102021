package com.walmart.test.service;

import java.util.Date;

public class TestPOJO {

	private int id;
	private int temperature;
	private int humidity;
	private String location;
	private Date timestamp;
	public TestPOJO(int id, int temperature, int humidity, String location) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.location = location;
	}
	
	public TestPOJO() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TestPOJO [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + ", location="
				+ location + ", timestamp=" + timestamp + "]";
	}
	
	
	
}
