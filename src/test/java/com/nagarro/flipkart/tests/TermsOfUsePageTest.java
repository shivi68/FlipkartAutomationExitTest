package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class TermsOfUsePageTest extends WebDriverFactory {

	@Test
	public void testNavigateToFlipkartTermsPage() {
		createTest("testNavigateToFlipkartTermsPage");
		try {
			logger.info("Starting test: testNavigateToFlipkartTermsPage");
			test.info("Starting test: testNavigateToFlipkartTermsPage");
			
			homePage.navigateToTermsOfUsePage();
			test.info("Navigated to the Terms Of Use Page.");

			Assert.assertTrue(homePage.isPageDisplayed(homePage.getFlipkartTerms()), "Terms Of Use Page is not displayed.");
			test.pass("Terms Of Use Page is displayed successfully.");
		    logger.info("Terms Of Use Page is displayed successfully.");
			
		} catch (AssertionError e) {
			logger.error("Test failed: Terms Of Use Page is not displayed: {}", e.getMessage());
	        handleTestFailure("Test failed: " + e.getMessage());
		}
	}
}
