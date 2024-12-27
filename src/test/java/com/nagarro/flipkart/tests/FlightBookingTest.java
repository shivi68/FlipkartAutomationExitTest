package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class FlightBookingTest extends WebDriverFactory {
	
	@Test
	public void testFlightBooking() {
		createTest("testFlightBooking");
		try {
			logger.info("Starting test: testFlightBooking");
			test.info("Starting test: testFlightBooking");
			
			flightBookingPage.flightBooking();
			test.info("Flight Booked Navigated to the Login Page.");

			Assert.assertTrue(flightBookingPage.isPageDisplayed(flightBookingPage.getLoginPage()), "Flight Booked and Login Page is not displayed.");
			test.pass("Flight Booked and Login Page is displayed successfully.");
		    logger.info("Flight Booked and Login Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Flight Booked and Login Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}

}
