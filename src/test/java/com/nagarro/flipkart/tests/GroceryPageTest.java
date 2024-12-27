package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class GroceryPageTest extends WebDriverFactory{
	
	@Test
	public void testNavigateToGroceryPage() {
		createTest("testNavigateToGroceryPage");
		try {
			logger.info("Starting test: testNaviagetToGroceryPage");
			test.info("Starting test: testNavigateToGroceryPage");
			
			homePage.navigateToGroceryPage();
			test.info("Navigated to the Grocery Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getGroceryPage()), "Grocery page is not displayed.");
			test.pass("Grocery page is displayed successfully.");
		    logger.info("Grocery page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Grocery page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}
	
}
