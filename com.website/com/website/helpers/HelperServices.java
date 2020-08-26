package com.website.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.website.compare.NumberComparator;
import com.website.driver.Driver;
import com.website.trip.Trip;

public class HelperServices implements HelperServicesDao {

	/**
	 * reduceTrips() takes an ArrayList<Driver> of drivers and creates a new reduced
	 * ArrayList<Driver> accumulating the miles and the hours they have spent
	 * driving.
	 * 
	 * @param ArrayList<Driver> drivers -> fed the fully build Driver object
	 *                          including Trips per driver
	 * @return ArrayList<Driver> reducedDriverTrips -> reduced on miles and hours
	 *         for each driver
	 */
	public ArrayList<Driver> reduceTrips(ArrayList<Driver> drivers) {
		ArrayList<Driver> reducedDriverTrips = new ArrayList<Driver>();
		ArrayList<Trip> reducedTrips = new ArrayList<Trip>();
		for (Driver d : drivers) {
			double totalHours = 0;
			double totalMiles = 0;
			if (d.getTrips().size() == 1) {
				reducedDriverTrips.add(d);
			} else if (d.getTrips().size() >= 2) {
				for (int i = 0; i < d.getTrips().size(); i++) {
					totalHours += d.getTrips().get(i).getHours();
					totalMiles += d.getTrips().get(i).getMiles();
				}
				Trip reducedTrip = new Trip(d.getName(), totalHours, totalMiles);
				reducedTrips.add(reducedTrip);
				Driver reducedDriver = new Driver(d.getName(), reducedTrips);
				reducedDriverTrips.add(reducedDriver);
			} else if (d.getTrips().size() == 0) {
				reducedDriverTrips.add(d);
			}
		}
		return reducedDriverTrips;
	}

	/**
	 * This method employs the .sort() method and uses a custom comparator which
	 * compares the miles for each drivers total trips. In order to to print the
	 * values out in descending order the .reversed() method is required.
	 * 
	 * @param ArrayList<Driver> drivers -> takes the reducedDriverTrips from
	 *                          reduceTrips()
	 * @return ArrayList<Driver> drivers -> sorts based on miles but this can be
	 *         changed in the custom comparator
	 */
	public ArrayList<Driver> sortDriversBasedOnMiles(ArrayList<Driver> drivers) {
		Collections.sort(drivers, new NumberComparator().reversed());
		return drivers;
	}


}
