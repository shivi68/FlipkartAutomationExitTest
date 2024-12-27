package com.nagarro.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class ContactPageTest extends WebDriverFactory {

	//Testing of navigating to contact page 
		@Test
		public void testContactPage() {
			createTest("testContactPage");
			try {
				logger.info("Starting test: testContactPage");
				test.info("Starting test: testContactPage");
				
				homePage.navigateToContactUsPage();
				test.info("Navigated to the Contact Us Page.");
				
				Assert.assertTrue(homePage.isPageDisplayed(homePage.getContactUsPage()), "Contact Us page is not displayed.");
				test.pass("Contact Us Page is displayed successfully.");
			    logger.info("Contact Us Page is displayed successfully.");
				
			} catch (AssertionError e) {
				logger.error("Test failed: Contact Us Page is not displayed: {}", e.getMessage());
		        handleTestFailure("Test failed: " + e.getMessage());
			}
		}
}
