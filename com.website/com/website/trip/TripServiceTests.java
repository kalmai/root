package com.website.trip;
import org.junit.*;

public class TripServiceTests {
	
	TripService tripService = new TripService("sample.txt");
	
	@Test
	public void set_trips_multiple_trips_to_the_list() {
		int result = tripService.setTrips("Dan").size();
		Assert.assertEquals(2,result);
	}
	
	@Test
	public void set_trips_adds_a_trip_to_the_list() {
		int result = tripService.setTrips("Lauren").size();
		Assert.assertEquals(1,result);
	}
	
//	@Test
//	public void trip_builder_creates_a_trip() {
//		String[] arr = {"Trip","Dan","07:15", "07:45", "17.3"};
//		String createdTripName = tripService.tripBuilder(arr).getName();
//		Assert.assertEquals("Dan", createdTripName);
//	}
//	
//	@Test
//	public void trip_builder_does_not_create_a_trip_when_less_than_5_or_greater_than_100() {
//		String[] arr = {"Trip","Dan","07:15", "07:45", "1.0"};
//		Trip trip = tripService.tripBuilder(arr);
//		Assert.assertNull(trip);
//	}
	
	
}