package com.nagarro.flipkart.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.ExcelUtils;
import com.nagarro.flipkart.utils.FilePaths;
import com.nagarro.flipkart.utils.WebDriverFactory;

public class PinCodeTest extends WebDriverFactory {
	
	@Test
	public void testPinCode() throws IOException {
		createTest("testPinCode");

		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
		String sheetName = "Pincode";

		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

		for (Map<String, String> testCase : testCases) {
			String testCaseName = testCase.get("TestCaseName");
			String executionRequired = testCase.get("Execution Required");
			String searchTerm = testCase.get("SearchTerm");
			String pincode = testCase.get("Pincode");
			
		if ("Yes".equalsIgnoreCase(executionRequired)) {
			logger.info("Executing test case: " + testCaseName);
			logger.info("Search Term: " + searchTerm);

				try {
					logger.info("Starting test: testPinCode");
					test.info("Starting test: testPinCode");

					homePage.searchItem(searchTerm);
					test.info("Navigated to the Searched Item Page");
				
					productPage.navigateToProductDetailsPage();
					productPage.verifyPinCode(pincode);
					
					Assert.assertTrue(productPage.isPageDisplayed(productPage.getInvalidPinCodeMsg()),
	                            "Pin Code Error Message is not displayed.");
	                test.pass("Pin Code Error Message is displayed successfully.");
	                logger.info("Pin Code Error Message is displayed successfully.");

	                } catch (AssertionError e) {
	                    logger.error("Test failed: Pin Code Error Message is not displayed: {}", e.getMessage());
	                    handleTestFailure("Test failed: " + e.getMessage());
	                }
			}
		}
	}
}
