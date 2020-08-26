package com.website.helpers;

import java.util.ArrayList;

import com.website.driver.Driver;

public interface HelperServicesDao {
	ArrayList<Driver> reduceTrips(ArrayList<Driver> drivers);
	ArrayList<Driver> sortDriversBasedOnMiles(ArrayList<Driver> drivers);
}