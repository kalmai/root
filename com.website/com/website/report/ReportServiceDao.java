package com.website.report;

import java.util.ArrayList;

import com.website.driver.Driver;

public interface ReportServiceDao {
	void printResults(ArrayList<Driver> drivers );
}