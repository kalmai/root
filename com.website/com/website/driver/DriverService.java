package com.website.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.website.trip.TripDao;

public class DriverService {

	String inputFile;
	TripDao dao;

	public DriverService(String inputFile, TripDao dao) {
		this.inputFile = inputFile;
		this.dao = dao;
	}

	/**
	 * Takes the string input prompted by the CLI and loops through it finding lines
	 * where the keyword "Driver" is included. Then it builds a driver to add to the
	 * drivers ArrayList which calls upon the setTrips method documented below.
	 * 
	 * @param String inputFile -> converted into a File
	 * @return ArrayList<Driver> drivers
	 */
	public ArrayList<Driver> getDrivers() {
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		try {
			File file = new File(inputFile);
			Scanner sc = new Scanner(file);
			String[] arr;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				arr = line.split(" ");
				if (arr.length == 2 && arr[0].equals("Driver") && !(hasDuplicateDriver(drivers, arr[1]))) {
					Driver driver = new Driver(arr[1], dao.setTrips(arr[1]));
					drivers.add(driver);
				}
			}
			sc.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return drivers;
	}

	/**
	 * Loops through the provided arraylist and returns either true or false
	 * depending on whether or not the driver's name is already in the arraylist.
	 * 
	 * @param ArrayList<Driver> drivers -> arraylist that is being built on the go
	 *                          from getDrivers()
	 * @param String            name -> arr[1] which is the name being parsed from
	 *                          the line to test against
	 * @return boolean
	 */
	public boolean hasDuplicateDriver(ArrayList<Driver> drivers, String name) {
		for (Driver d : drivers) {
			if (d.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
