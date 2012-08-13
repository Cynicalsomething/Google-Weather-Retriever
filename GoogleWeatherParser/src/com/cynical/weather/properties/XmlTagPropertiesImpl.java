package com.cynical.weather.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class XmlTagPropertiesImpl extends Properties implements XmlTagProperties {
	private static final long serialVersionUID = -4289985737817403960L;
	
	private static final String WEATHER_KEY = "weather";
	private static final String CURRENT_CONDITIONS_KEY = "current_conditions";
	private static final String CONDITION_KEY = "condition";
	private static final String TEMP_FAHRENHEIT_KEY = "temp_F";
	private static final String TEMP_CELCIUS_KEY = "temp_C";
	private static final String HUMIDITY_KEY = "humidity";
	private static final String WEATHER_CONDITION_ICON_KEY = "weather_condition_icon";
	private static final String WIND_CONDITIONS_KEY = "wind";
	private static final String DATA_ATTRIBUTE_KEY = "data_attribute";
	
	public XmlTagPropertiesImpl() {
		InputStream xmlStream;
		try {
			//xmlStream = new FileInputStream(new File("resources/properties/properties.xml"));
			xmlStream = getClass().getClassLoader().getResourceAsStream("properties/properties.xml");
			this.loadFromXML(xmlStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getWeatherTag() {
		return getProperty(WEATHER_KEY);
	}
	
	public String getCurrentConditionsTag() {
		return getProperty(CURRENT_CONDITIONS_KEY);
	}
	
	public String getConditionTag() {
		return getProperty(CONDITION_KEY);
	}
	
	public String getTempFahrenheitTag() {
		return getProperty(TEMP_FAHRENHEIT_KEY);
	}
	
	public String getTempCelciusTag() {
		return getProperty(TEMP_CELCIUS_KEY);
	}
	
	public String getHumidityTag() {
		return getProperty(HUMIDITY_KEY);
	}
	
	public String getWeatherConditionIconTag() {
		return getProperty(WEATHER_CONDITION_ICON_KEY);
	}
	
	public String getWindConditionsTag() {
		return getProperty(WIND_CONDITIONS_KEY);
	}
	
	public String getDataAttribute() {
		return getProperty(DATA_ATTRIBUTE_KEY);
	}

}
