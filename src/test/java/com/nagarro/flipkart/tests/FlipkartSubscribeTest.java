package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class FlipkartSubscribeTest extends WebDriverFactory {
	
	@Test
	public void testNavigateToSubscribePage() {
		createTest("testNavigateToSubscribePage");
		try {
			logger.info("Starting test: testNavigateToSubscribePage");
			test.info("Starting test: testNavigateToSubscribePage");
			
			homePage.navigateToFlipkartStoriesSubscribePage();
			test.info("Navigated to the Subscribe Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getSubscribeForm()), "Subscribe Page is not displayed.");
			test.pass("Subscribe Page is displayed successfully.");
		    logger.info("Subscribe Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Subscribe Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}

}
