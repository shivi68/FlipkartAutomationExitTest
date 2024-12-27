package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class ShopsyNewSitePageTest extends WebDriverFactory{

	@Test
	public void testNavigateToShopsyPage() {
		createTest("testNavigateToShopsyPage");
		try {
			logger.info("Starting test: testNavigateToShopsyPage");
			test.info("Starting test: testNavigateToShopsyPage");
			
			homePage.navigateToShopsyPage();
			test.info("Navigated to the Shopsy Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getShopsyPage()), "Shopsy Page is not displayed.");
			test.pass("Shopsy Page is displayed successfully.");
		    logger.info("Shopsy Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Shopsy Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}
}
