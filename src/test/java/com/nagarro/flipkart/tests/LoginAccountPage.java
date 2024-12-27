package com.nagarro.flipkart.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.ExcelUtils;
import com.nagarro.flipkart.utils.FilePaths;
import com.nagarro.flipkart.utils.WebDriverFactory;

public class LoginAccountPage extends WebDriverFactory {

	@Test
	public void testLoginOtpPage() throws IOException, InterruptedException{
		createTest("testLoginAccountPage");

		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
		String sheetName = "LoginSignUpTest";

		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

		for (Map<String, String> testCase : testCases) {
			String testCaseName = testCase.get("TestCaseName");
			String executionRequired = testCase.get("Execution Required");
			String phone = testCase.get("Phone");

			if ("Yes".equalsIgnoreCase(executionRequired)) {
				logger.info("Executing test case: " + testCaseName);
				logger.info("Search Term: " + phone);

				try {
					logger.info("Starting test: testLoginAccountPage");
					test.info("Starting test: testLoginAccountPage");

					loginPage.verifyOtpSentSuccessfully(phone);
					test.info("Navigated to the Login Otp Sent Page.");

					Assert.assertTrue(homePage.isPageDisplayed(loginPage.getLoginOtpPage()),
							"Login Otp Sent Page is not displayed.");
					test.pass("Login Otp Sent Page is displayed successfully.");
					logger.info("Login Otp Sent Page is displayed successfully.");

				} catch (AssertionError e) {
					logger.error("Test failed: Login Otp Sent Page is not displayed: {}", e.getMessage());
					handleTestFailure("Test failed: " + e.getMessage());
				}
			}
		}
	}
}
