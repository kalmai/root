package com.website.driver;
import java.util.ArrayList;

import org.junit.*;

import com.website.trip.Trip;
import com.website.trip.TripService;

public class DriverTests {
	
	TripService tripService = new TripService("sample.txt");
	DriverService driverService = new DriverService("sample.txt", tripService);
	
	@Test
	public void get_driver_names() {
		ArrayList<Driver> drivers = driverService.getDrivers();
		int result = drivers.size();
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void file_cannot_be_processed() {
		String str = "";
		TripService tripService = new TripService(str);
		DriverService driverService = new DriverService(str, tripService);
		ArrayList<Driver> drivers = driverService.getDrivers();
		int result = drivers.size();
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void has_duplicate_driver_returns_true() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip1 = new Trip("Dan", 0.500001, 17.3);
		trips.add(trip1);
		Driver dan = new Driver("Dan", trips);

		ArrayList<Driver> driversNew = new ArrayList<Driver>();
		driversNew.add(dan);
		boolean result = driverService.hasDuplicateDriver(driversNew, "Dan");
		Assert.assertTrue(result);
	}
	
	@Test
	public void has_duplicate_driver_returns_false() {
		ArrayList<Driver> driversNew = new ArrayList<Driver>();
		boolean result = driverService.hasDuplicateDriver(driversNew, "Dan");
		Assert.assertFalse(result);
		
	}
	
	@Test
	public void arr_length_not_equal_to_one_does_not_add_driver() {
		TripService tripService = new TripService("duplicate-drivers.txt");
		DriverService driverServiceDupe= new DriverService("duplicate-drivers.txt", tripService);
		
		int result = driverServiceDupe.getDrivers().size();
		Assert.assertEquals(1, result);
	}
}

