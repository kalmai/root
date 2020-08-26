package com.website.helpers;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.website.driver.Driver;
import com.website.trip.Trip;


public class HelperServicesTests {
	
	HelperServices helper = new HelperServices();

	@Test
	public void reduce_trips_reduces_all_trips_down_to_one_trip_for_a_driver() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip1 = new Trip("Dan", 0.500001, 17.3);
		Trip trip2 = new Trip("Dan", 0.333334, 21.8);
		trips.add(trip1);
		trips.add(trip2);
		
		Driver dan = new Driver("Dan", trips);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(dan);
		int result = helper.reduceTrips(drivers).get(0).getTrips().size();
		Assert.assertEquals(1,result);
	}
	
	@Test
	public void reduce_trips_does_nothing_when_fed_an_empty_trip_arraylist() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		
		Driver kumi = new Driver("Kumi", trips);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(kumi);
		int result = helper.reduceTrips(drivers).get(0).getTrips().size();
		Assert.assertEquals(0,result);	
	}
	@Test 
	public void reduce_trips_immediately_adds_to_arraylist_when_trips_size_is_one() {	
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip1 = new Trip("Dan", 0.500001, 17.3);
		trips.add(trip1);
		
		Driver dan = new Driver("Dan", trips);
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(dan);
		int result = helper.reduceTrips(drivers).get(0).getTrips().size();
		Assert.assertEquals(1,result);
	}
	
	@Test
	public void sort_places_driver_with_most_miles_at_top() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip1 = new Trip("Dan", 0.500001, 17.3);
		trips.add(trip1);
		Driver dan = new Driver("Dan", trips);
		
		ArrayList<Trip> trips2 = new ArrayList<Trip>();
		Trip laurenTrip = new Trip("Lauren", 1.2500025, 42.0);
		trips2.add(laurenTrip);
		Driver lauren = new Driver("Lauren", trips2);
		
		ArrayList<Driver> driversNew = new ArrayList<Driver>();
		driversNew.add(dan);
		driversNew.add(lauren);
		
		ArrayList<Driver> sortedList = helper.sortDriversBasedOnMiles(driversNew);
		String mostMilesDriver = sortedList.get(0).getName();
		Assert.assertEquals("Lauren",mostMilesDriver);
	}

	@Test
	public void sort_handles_empty_trip_drivers_properly() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip1 = new Trip("Dan", 0.500001, 17.3);
		trips.add(trip1);
		Driver dan = new Driver("Dan", trips);
		
		ArrayList<Trip> trips2 = new ArrayList<Trip>();
		Driver lauren = new Driver("Lauren", trips2);
		
		ArrayList<Driver> driversNew = new ArrayList<Driver>();
		driversNew.add(dan);
		driversNew.add(lauren);
		
		ArrayList<Driver> sortedList = helper.sortDriversBasedOnMiles(driversNew);
		String mostMilesDriver = sortedList.get(0).getName();
		Assert.assertEquals("Dan",mostMilesDriver);
	}
	
}
