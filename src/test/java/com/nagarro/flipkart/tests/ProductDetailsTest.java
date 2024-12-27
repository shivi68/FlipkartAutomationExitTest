package com.nagarro.flipkart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import com.nagarro.flipkart.utils.FilePaths;
import com.nagarro.flipkart.utils.ExcelUtils;

import com.nagarro.flipkart.utils.WebDriverFactory;

public class ProductDetailsTest extends WebDriverFactory {

	@Test
	public void testProductDetails() throws IOException {
		createTest("testProductDetails");

		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
		String sheetName = "Search";

		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

		for (Map<String, String> testCase : testCases) {
			String testCaseName = testCase.get("TestCaseName");
			String executionRequired = testCase.get("Execution Required");
			String searchTerm = testCase.get("SearchTerm");

		if ("Yes".equalsIgnoreCase(executionRequired)) {
			logger.info("Executing test case: " + testCaseName);
			logger.info("Search Term: " + searchTerm);

				try {
					logger.info("Starting test: testProductDetails");
					test.info("Starting test: testProductDetails");

					homePage.searchItem(searchTerm);
					test.info("Navigated to the Searched Item Page");
				
					productPage.navigateToProductDetailsPage();
					
					Assert.assertTrue(productPage.isPageDisplayed(productPage.getProductDetails()),
	                            "Product details page is not displayed.");
	                test.pass("Product details page is displayed successfully.");
	                logger.info("Product details page is displayed successfully.");

	                } catch (AssertionError e) {
	                    logger.error("Test failed: Product details page is not displayed: {}", e.getMessage());
	                    handleTestFailure("Test failed: " + e.getMessage());
	                }
			}
		}
	}
}
