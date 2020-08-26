package com.website.compare;

import java.util.Comparator;

import com.website.driver.Driver;

/**
 * This class uses the Collecctions.sort() method by wrapping the miles from the
 * trip object as Double which allows for them to be compared with the compareTo
 * method which is used in .sort. Is fed the reduced ArrayList<Driver> drivers.
 * 
 * @param Driver o1 -> first Driver object being compared
 * @param Driver o2 -> second Driver object being compared
 * @return int -1/0/1 -> returns one of these three values based on compareTo()
 */
public class NumberComparator implements Comparator<Driver> {

	public int compare(Driver o1, Driver o2) {
		if (o1.getTrips().size() == 1 && o2.getTrips().size() == 1) {
			Double o1Miles = o1.getTrips().get(0).getMiles();
			Double o2Miles = o2.getTrips().get(0).getMiles();
			return o1Miles.compareTo(o2Miles);
		} else if (o1.getTrips().size() == 0 && o2.getTrips().size() == 0) {
			return 0;
		} else if (o1.getTrips().size() == 0) {
			return -1;
		} else {
			return 1;
		}
	}
}
