package com.myfirstapp.sean;

public class XMLDataCollected {

	int temp = 0;
	String city = null;
	
	public void setCity(String c) {
		city = c;
	}
	
	public void setTemp(int t) {
		temp = t;
	}
	
	public String dataToString() {
		return "In " + city + " the Current Temperature is F is " + temp + " degrees";
	}
}
