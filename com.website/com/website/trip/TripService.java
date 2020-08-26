package com.website.trip;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TripService implements TripDao {

	String inputFile;

	public TripService(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * The array from the getDrivers method is passed to this method along with the
	 * string that was passed to the getDrivers method to build a file and it loops
	 * through the file once more to find where there are instances of exact names
	 * and the other keyword "Trip" and builds a trip.
	 * 
	 * @param String name -> was originally arr[1] from getDrivers()
	 * @param String inputFile -> just the same String the user was prompted for
	 *               earlier
	 * @return ArrayList<Trips> trips
	 */
	public ArrayList<Trip> setTrips(String name) {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		try {
			File file = new File(inputFile);
			Scanner sc = new Scanner(file);
			String[] arr;
			while (sc.hasNextLine()) {
				String tripLine = sc.nextLine();
				arr = tripLine.split(" ");
				if (arr[0].equals("Trip") && arr[1].equals(name)) {
					LocalTime start = LocalTime.parse(arr[2], DateTimeFormatter.ofPattern("HH:mm"));
					LocalTime end = LocalTime.parse(arr[3], DateTimeFormatter.ofPattern("HH:mm"));
					double hours = (MINUTES.between(start, end) * 0.0166667);
					double mph = Double.parseDouble(arr[4]) / hours;
					if (mph > 5 && mph < 100) {
						Trip trip = new Trip(arr[1], hours, Double.parseDouble(arr[4]));
						trips.add(trip);
					}
				}
			}
			sc.close();
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
		return trips;
	}
}
