package com.nagarro.flipkart.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nagarro.flipkart.utils.ExcelUtils;
import com.nagarro.flipkart.utils.FilePaths;
import com.nagarro.flipkart.utils.WebDriverFactory;

public class SearchItemTest extends WebDriverFactory{
	
	
	@Test
	public void testSearchItem() throws IOException {
		createTest("testSearchItem");

		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
		String sheetName = "Search";

		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

		for (Map<String, String> testCase : testCases) {
			String testCaseName = testCase.get("TestCaseName");
			String executionRequired = testCase.get("Execution Required");
			String searchTerm = testCase.get("SearchTerm");

			if ("Yes".equalsIgnoreCase(executionRequired)) {
				logger.info("Executing test case: {}" , testCaseName);
				logger.info("Search Term: {}" , searchTerm);

				try {
					logger.info("Starting test: testSearchItem");
					test.info("Starting test: testSearchItem");

					homePage.searchItem(searchTerm);
					test.info("Navigated to the Searched Item Page");
					productPage.searchedItemPage();

					Assert.assertTrue(productPage.isPageDisplayed(productPage.getSearchResult()),
							"Search results are not displayed.");
					test.pass("Search results are displayed successfully.");
					logger.info("Search results are displayed successfully for the term: {}", searchTerm);

				} catch (AssertionError e) {
					logger.error("Test failed: Search Item page is not displayed: {}", e.getMessage());
					handleTestFailure("Test failed: " + e.getMessage());
				}

			}
		}
	}
}
