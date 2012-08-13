package com.cynical.weather.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cynical.weather.properties.XmlTagProperties;
import com.cynical.weather.properties.XmlTagPropertiesImpl;

public class GoogleWeatherHandler extends DefaultHandler {
	
	private XmlTagProperties tagNames;
	private CurrentWeatherConditions currentConditions;
	
	private boolean inCurrentConditions;
	private boolean inWeather;
	
	public GoogleWeatherHandler() {
		currentConditions = new CurrentWeatherConditions();
		tagNames = new XmlTagPropertiesImpl();
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		String value = attributes.getValue(tagNames.getDataAttribute());
		
		if (qName.equals(tagNames.getCurrentConditionsTag())) {
			inCurrentConditions = true;
		}
		else if (qName.equals(tagNames.getTempFahrenheitTag())) {
			if(isInCurrentConditions()) {
				currentConditions.setTempF(Integer.parseInt(value));
			}
		}
		else if (qName.equals(tagNames.getTempCelciusTag())) {
			if(isInCurrentConditions()) {
				currentConditions.setTempC(Integer.parseInt(value));
			}
		}
		else if (qName.equals(tagNames.getHumidityTag())) {
			if(isInCurrentConditions()) {
				currentConditions.setHumidityText(value);
			}
		}
		else if (qName.equals(tagNames.getConditionTag())) {
			if (isInCurrentConditions()) {
				currentConditions.setCondition(value);
			}
		}
		else if (qName.equals(tagNames.getWeatherConditionIconTag())) {
			if(isInCurrentConditions()) {
				currentConditions.setIconURL(value);
			}
		}
		else if (qName.equals(tagNames.getWindConditionsTag())) {
			if(isInCurrentConditions()) {
				currentConditions.setWind(value);
			}
		}
		else if (qName.equals(tagNames.getWeatherTag())) {
			inWeather = true;
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(tagNames.getCurrentConditionsTag())) {
			inCurrentConditions = false;
		}
		else if (qName.equals(tagNames.getWeatherTag())) {
			inWeather = false;
		}
	}
	
	private boolean isInCurrentConditions() {
		return inWeather && inCurrentConditions;
	}

	public CurrentWeatherConditions getCurrentConditions() {
		return currentConditions;
	}
	
}
