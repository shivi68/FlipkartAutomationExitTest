package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class AboutPageTest extends WebDriverFactory {

	//Testing Navigating to about page 
	@Test
	public void testAboutPage() {
		createTest("testAboutPage");
		try {
			logger.info("Starting test: testAboutPage");
			test.info("Starting test: testAboutPage");
			
			homePage.navigateToAboutUsPage();
			test.info("Navigated to the About Us Page.");

			logger.debug("Asserting if About Us Page is displayed");
			Assert.assertTrue(homePage.isPageDisplayed(homePage.getAboutUsPage()), "About Us Page is not displayed.");
			test.pass("About Us Page is displayed successfully.");
		    logger.info("About Us Test Completed Successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: About Us page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}
}
