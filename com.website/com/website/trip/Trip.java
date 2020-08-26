package com.website.trip;

public class Trip {

	String name;
	double hours;
	double miles;

	public Trip(String name, double hours, double miles) {
		this.name = name;
		this.miles = miles;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
}
