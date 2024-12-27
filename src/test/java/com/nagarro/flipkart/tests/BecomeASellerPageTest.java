// package com.nagarro.flipkart.tests;

// import org.testng.Assert;
// import org.testng.annotations.Test;

// import com.nagarro.flipkart.utils.WebDriverFactory;

// public class BecomeASellerPageTest extends WebDriverFactory {
	
// 	@Test
// 	public void testBecomeASeller() {
// 		createTest("testBecomeASeller");
// 		try {
// 			logger.info("Starting test: testBecomeASeller");
// 			test.info("Starting test: testBecomeASeller");
			
// 			homePage.navigateToBecomeASellerPage();
// 			test.info("Navigated to the Become A Seller Page.");

// 			Assert.assertTrue(homePage.isPageDisplayed(homePage.getSellerDashboard()), "Seller Page is not displayed.");
// 			test.pass("Seller Page is displayed successfully.");
// 		    logger.info("Seller Page is displayed successfully.");
			
// 		} catch (AssertionError e) {
// 			logger.error("Test failed: Seller Page is not displayed: {}", e.getMessage());
// 	        handleTestFailure("Test failed: " + e.getMessage());
// 		}
// 	}
// }
