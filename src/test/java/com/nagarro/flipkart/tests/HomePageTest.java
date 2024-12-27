package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class HomePageTest extends WebDriverFactory {

		// Testing Home Page Title
		@Test
		public void testHomePageTitle() {
			createTest("testHomePageTitle");
			try {
				logger.info("Starting test: testHomePageTitle");
				test.info("Starting test: testHomePageTitle");
				String actualTitle = homePage.getHomePageTitle();
				String expectedTitle = configReader.getExpectedHomePageTitle();

				test.info("Actual Title: " + actualTitle);
				test.info("Expected Title: " + expectedTitle);

				Assert.assertTrue(actualTitle.contains(expectedTitle), "Home Page title did not match.");
				test.pass("Home Page title matched successfully.");
				logger.info("Home Page title matched successfully.");
			} catch (AssertionError e) {
				logger.error("Home Page title test failed: {}", e.getMessage());
				handleTestFailure("Test failed: " + e.getMessage());
			}
		}
}
