package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class NavigateToCartPageTest extends WebDriverFactory {

	@Test
	public void testNavigateToCartPage() {
		createTest("testNavigateToCartPage");
		try {
			logger.info("Starting test: testNavigateToCartPage");
			test.info("Starting test: testNavigateToCartPage");
			
			homePage.clickCartIcon();
			test.info("Navigated to the Cart Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getCartPage()), "Cart Page is not displayed.");
			test.pass("Cart Page is displayed successfully.");
		    logger.info("Cart Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Cart Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}
	
}
