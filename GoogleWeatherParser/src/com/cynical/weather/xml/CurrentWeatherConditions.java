package com.cynical.weather.xml;

public class CurrentWeatherConditions {
	
	private String condition = "Unknown";
	private int tempF = 0;
	private int tempC = 0;
	private double humidity = 0.0;
	private String humidityText = ""; //TODO: remove this
	private String iconURL = "";
	private String wind = "";
	
	public CurrentWeatherConditions() {
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getTempF() {
		return tempF;
	}
	public void setTempF(int tempF) {
		this.tempF = tempF;
	}
	public int getTempC() {
		return tempC;
	}
	public void setTempC(int tempC) {
		this.tempC = tempC;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getHumidityText() {
		return humidityText;
	}
	public void setHumidityText(String humidityText) {
		this.humidityText = humidityText;
	}
	

}
