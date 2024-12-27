package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class GiftCardsTest extends WebDriverFactory {

	@Test
	public void testNavigateToGiftCardPage() {
		createTest("testNavigateToGiftCardPage");
		try {
			logger.info("Starting test: testNavigateToGiftCardPage");
			test.info("Starting test: testNavigateToGiftCardPage");
			
			homePage.navigateToGiftCardPage();
			test.info("Navigated to the Gift Card Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getGiftCardPage()), "Gift Card Page is not displayed.");
			test.pass("Gift Card Page is displayed successfully.");
		    logger.info("Gift Card Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Gift Card Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}
}
