package com.website.compare;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.website.driver.Driver;
import com.website.trip.Trip;

public class NumberComparatorTests {
	
	NumberComparator numCompare = new NumberComparator();
	
	@Test
	public void compare_compares_two_values() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip1 = new Trip("Dan", 0.500001, 17.3);
		trips.add(trip1);
		Driver dan = new Driver("Dan", trips);
		
		ArrayList<Trip> trips2 = new ArrayList<Trip>();
		Trip laurenTrip = new Trip("Lauren", 1.2500025, 42.0);
		trips2.add(laurenTrip);
		Driver lauren = new Driver("Lauren", trips2);
		
		int results = numCompare.compare(dan, lauren);
		Assert.assertEquals(-1, results);
	}
	
	@Test
	public void compare_returns_negative_one_when_o1_has_no_trips() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Driver dan = new Driver("Dan", trips);
		
		ArrayList<Trip> trips2 = new ArrayList<Trip>();
		Trip laurenTrip = new Trip("Lauren", 1.2500025, 42.0);
		trips2.add(laurenTrip);
		Driver lauren = new Driver("Lauren", trips2);
		
		int results = numCompare.compare(dan, lauren);
		Assert.assertEquals(-1, results);
	}
	
	@Test
	public void compare_returns_one_when_o2_has_no_trips() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Driver dan = new Driver("Dan", trips);
		
		ArrayList<Trip> trips2 = new ArrayList<Trip>();
		Trip laurenTrip = new Trip("Lauren", 1.2500025, 42.0);
		trips2.add(laurenTrip);
		Driver lauren = new Driver("Lauren", trips2);
		
		int results = numCompare.compare(lauren, dan);
		Assert.assertEquals(1, results);
	}
	
	@Test
	public void compare_returns_zero_when_both_are_empty() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Driver dan = new Driver("Dan", trips);
		
		ArrayList<Trip> trips2 = new ArrayList<Trip>();
		Driver lauren = new Driver("Lauren", trips2);
		
		int results = numCompare.compare(lauren, dan);
		Assert.assertEquals(0, results);
	}
}
