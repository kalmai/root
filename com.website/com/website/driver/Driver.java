package com.website.driver;

import java.util.ArrayList;

import com.website.trip.Trip;

public class Driver {
	String name;
	ArrayList<Trip> trips;
	
	public Driver(String name, ArrayList<Trip> trips) {
		this.name = name;
		this.trips = trips;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
	
}
