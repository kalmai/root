package com.website.root_work_sample.cli;

import java.util.ArrayList;
import java.util.Scanner;

import com.website.driver.Driver;
import com.website.driver.DriverService;
import com.website.helpers.HelperServices;
import com.website.report.ReportService;
import com.website.trip.TripService;

public class app {

	public static void main(String[] args) {
		/**
		 * The flow of this program is as follows:
		 * 
		 * driverService.getDrivers() : parses the file for the keywords "Driver" or
		 * "Trip" and build an ArrayList of drivers (within the getDrivers() method it
		 * calls upon setTrips()) helpers.reduceTrips() : accumulates the miles and
		 * hours if the driver has multiple trips helpers.sortDriverBasedOnMiles() :
		 * sorts drivers based on miles in descending order reportService.printResults()
		 * : prints results in the console for the user
		 */

		ReportService reportService = new ReportService();
		HelperServices helpers = new HelperServices();

		while (true) {
			Scanner prompt = new Scanner(System.in);
			int number = 0;
			do {
				System.out.println("1) Choose a file to process driving history");
				System.out.println("2) Quit");
				while (!prompt.hasNextInt()) {
					System.out.printf("Please select a valid option\n\n");
					System.out.println("1) Choose a file to process driving history");
					System.out.println("2) Quit");
					prompt.next();
				}
				number = prompt.nextInt();
				if (number == 1) {
					System.out.print("Select your file >>> ");

					Scanner input = new Scanner(System.in);
					String file = input.nextLine();

					TripService tripService = new TripService(file);
					DriverService driverService = new DriverService(file, tripService);
					ArrayList<Driver> drivers = driverService.getDrivers();
					if (drivers.size() == 0 || drivers.get(0).getTrips().size() == 0) {
						System.out.println("Please select a file that contains:Driver John");
						System.out.println("This is sample data -->           :Trip John 10:01 13:02 121.1");
						System.out.println("formatting                register driver|name");
						System.out.println("                          register trip|name|start|end  |miles");
					} else {
						ArrayList<Driver> reducedDrivers = helpers.reduceTrips(drivers);
						ArrayList<Driver> sortedDrivers = helpers.sortDriversBasedOnMiles(reducedDrivers);
						reportService.printResults(sortedDrivers);
					}
				} else if (number == 2) {
					prompt.close();
					System.exit(0);
				}
			} while (number != 1 || number != 2);
		}
	}
}
