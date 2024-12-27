// package com.nagarro.flipkart.tests;

// import java.io.IOException;
// import java.util.List;
// import java.util.Map;

// import org.testng.Assert;
// import org.testng.annotations.Test;

// import com.nagarro.flipkart.utils.ExcelUtils;
// import com.nagarro.flipkart.utils.FilePaths;
// import com.nagarro.flipkart.utils.WebDriverFactory;

// public class AddAndRemoveItemFromCartTest extends WebDriverFactory {
	
// 	@Test
// 	public void testAddAndRemoveFromCart() throws IOException {
// 		createTest("testAddAndRemoveFromCart");

// 		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
// 		String sheetName = "AddToCart";

// 		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

// 		for (Map<String, String> testCase : testCases) {
// 			String testCaseName = testCase.get("TestCaseName");
// 			String executionRequired = testCase.get("Execution Required");
// 			String searchTerm = testCase.get("SearchTerm");

// 			if ("Yes".equalsIgnoreCase(executionRequired)) {
// 				logger.info("Executing test case: " + testCaseName);
// 				logger.info("Search Term: " + searchTerm);

// 				try {
// 					logger.info("Starting test: testAndRemoveFromCart");
// 					test.info("Starting test: testAndRemoveFromCart");

// 					homePage.searchItem(searchTerm);
// 					test.info("Navigated to the Searched Item Page");
// 					productPage.navigateToProductDetailsPage();
// 					test.info("Product Details are displayed");
// 					cartPage.removeProductFromCart();
// 					test.info("Product Remove From Cart Successfully.");

// 					Assert.assertTrue(cartPage.isPageDisplayed(cartPage.getSuccessRemoveMsg()),
// 							"Product Remove Message From Cart is not displayed.");
// 					test.pass("Product Remove Message From Cart is displayed successfully.");
// 					logger.info("Product Remove Message From Cart is displayed successfully.");
					
// 				} catch (AssertionError e) {
// 					logger.error("Test failed: Product Remove Message From Cart is not displayed: {}", e.getMessage());
// 					handleTestFailure("Test failed: " + e.getMessage());
// 				}

// 			}
// 		}
// 	}
// }
