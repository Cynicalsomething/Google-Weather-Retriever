package com.cynical.weather.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * An class that will retrieve weather information from the Google Weather API using latitude and longitude.
 * @author Adam
 *
 */
public class GoogleWeatherRequest {
	
	private static final String BASE_URL = "http://www.google.com/ig/api?weather=,,,";
	
	private URL requestURL;
	
	/**
	 * Creates a new request object using latitude and longitude in the format of XX.XXX...
	 * This constructor will convert the latitude and longitude to E6 format.
	 * @param latitude The latitude of the location to retrieve weather data
	 * @param longitude The longitude of the location to retrieve weather data
	 */
	public GoogleWeatherRequest(double latitude, double longitude) {
		try {
			requestURL = new URL(BASE_URL + (int)(latitude * 1E6) + "," + (int)(longitude * 1E6));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets up the connection and returns an InputStream object.
	 * @return The InputStream object that was created.
	 */
	public InputStream connect() {
		try {
			HttpURLConnection connection = (HttpURLConnection) requestURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");
			
			return connection.getInputStream();
			
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
