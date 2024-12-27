package com.nagarro.flipkart.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.ExcelUtils;
import com.nagarro.flipkart.utils.FilePaths;
import com.nagarro.flipkart.utils.WebDriverFactory;

public class SaveForLaterTest extends WebDriverFactory {
	
	@Test(groups = { "cart" }, enabled = false)  
	public void testSaveForLater() throws IOException {
		createTest("testSaveForLater");

		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
		String sheetName = "CommonCartTests";

		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

		for (Map<String, String> testCase : testCases) {
			String testCaseName = testCase.get("TestCaseName");
			String executionRequired = testCase.get("Execution Required");
			String searchTerm = testCase.get("SearchTerm");

			if ("Yes".equalsIgnoreCase(executionRequired)) {
				logger.info("Executing test case: " + testCaseName);
				logger.info("Search Term: " + searchTerm);

				try {
					logger.info("Starting test: testSaveForLater");
					test.info("Starting test: testSaveForLater");

					homePage.searchItem(searchTerm);
					test.info("Navigated to the Searched Item Page");
					productPage.navigateToProductDetailsPage();
					test.info("Product Details are displayed");
					cartPage.saveForLater();
					test.info("Product Saved For Later");

					Assert.assertTrue(cartPage.isPageDisplayed(cartPage.getSuccessRemoveMsg()),
							"Product Saved For Later Message is not displayed.");
					test.pass("Product Saved For Later Message From Cart is displayed successfully.");
					logger.info("Product Saved For Later Message From Cart is displayed successfully.");
					
				} catch (AssertionError e) {
					logger.error("Test failed: Product Saved For Later Message From Cart is not displayed: {}", e.getMessage());
					handleTestFailure("Test failed: " + e.getMessage());
				}
			}
		}
	}
}
