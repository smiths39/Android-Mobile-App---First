package com.myfirstapp.sean;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlingXMLStuff extends DefaultHandler {

	private XMLDataCollected info = new XMLDataCollected();
	
	public String getInformation() {
		return info.dataToString();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (localName.equals("city")) {
			String city = attributes.getValue("data");
			info.setCity(city);
		} else if (localName.equals("temp_f")) {
			String t = attributes.getValue("data");
			int temp = Integer.parseInt(t);
			info.setTemp(temp);
		}
	}
}
