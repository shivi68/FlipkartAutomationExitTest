package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class MobilePageTest extends WebDriverFactory {

		@Test
		public void testMobilePage() {
			createTest("testMobilePage");
			try {
				logger.info("Starting test: testMobilePage");
				test.info("Starting test: testMobilePage");
				
				homePage.navigateToMobileLinkPage();
				test.info("Navigated to the Mobile Link Page.");

				Assert.assertTrue(homePage.isPageDisplayed(homePage.getMobilePageHeader()), "Mobile Link page is not displayed.");
				test.pass("Mobile Link Page is displayed successfully.");
			    logger.info("Mobile Link Page is displayed successfully.");
				
			} catch (AssertionError e) {
				logger.error("Test failed: Mobile Link Page is not displayed: {}", e.getMessage());
		        handleTestFailure("Test failed: " + e.getMessage());
			}
		}
	}
