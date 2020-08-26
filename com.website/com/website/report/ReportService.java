package com.website.report;

import java.util.ArrayList;

import com.website.driver.Driver;
import com.website.trip.Trip;

public class ReportService implements ReportServiceDao {
	/**
	 * Prints out the sorted and reduced list in the console for the user in
	 * descending order.
	 * 
	 * @param ArrayList<Driver> drivers -> takes the fully sorted/reduced list
	 */
	public void printResults(ArrayList<Driver> drivers) {
		for (Driver d : drivers) {
			ArrayList<Trip> trip = d.getTrips();
			if (trip.size() == 0) {
				System.out.printf("%s: 0 miles\n", d.getName());
			} else {
				Trip t = d.getTrips().get(0);
				double mph = Math.round(t.getMiles() / t.getHours());
				System.out.printf("%s: %s miles @ %.0f mph\n", d.getName(), Math.round(t.getMiles()), mph);
			}
		}
		System.out.println();
	}
}