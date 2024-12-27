package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class NotificationPageTest extends WebDriverFactory{
	
	@Test 
	public void testNavigateToNotificationPage() {
		createTest("testNavigateToNotificationPage");
		try {
			logger.info("Starting test: testNavigateToNotificationPage");
			test.info("Starting test: testNavigateToNotificationPage");
			
			homePage.navigateToNotificationPreferences();
			test.info("Navigated to the Notification Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getNotificationPage()), "Notification Page is not displayed.");
			test.pass("Notification Page is displayed successfully.");
		    logger.info("Notification Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Notification Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}

}
