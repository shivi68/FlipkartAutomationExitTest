package com.nagarro.flipkart.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.flipkart.utils.ExcelUtils;
import com.nagarro.flipkart.utils.FilePaths;
import com.nagarro.flipkart.utils.WebDriverFactory;

public class CareersPageTest extends WebDriverFactory {

	@Test(groups = { "navigation", "smoke" }, priority = 1)
	public void testNavigateToCareersPage() {
		createTest("testNavigateToCareersPage");
		try {
			logger.info("Starting test: testNavigateToCareersPage");
			test.info("Starting test: testNavigateToCareersPage");

			careersPage.navigateToCareersPage();
			test.info("Navigated to the Careers Page.");

			Assert.assertTrue(careersPage.isPageDisplayed(careersPage.getCareersPageHeader()),
					"Careers Page is not displayed.");
			test.pass("Carrers Page is displayed successfully.");
			logger.info("Carrers Page is displayed successfully.");

		} catch (AssertionError e) {
			logger.error("Test failed: Careers Page is not displayed: {}", e.getMessage());
			handleTestFailure("Test failed: " + e.getMessage());
		}
	}

	@Test(groups = { "navigation", "smoke" }, priority = 2)
	public void testNavigatetoJobsPage() {
		createTest("testNavigateToJobsPage");
		try {
			logger.info("Starting test: testNavigateToJobsPage");
			test.info("Starting test: testNavigateToJobsPage");

			careersPage.navigateToJobsPage();
			test.info("Navigated to the Jobs Page.");

			Assert.assertTrue(careersPage.isPageDisplayed(careersPage.getCurrentOpeningHeader()),
					"Job Page is not displayed.");

			test.pass("Jobs Page is displayed successfully.");
			logger.info("Jobs Page is displayed successfully.");

		} catch (AssertionError e) {
			logger.error("Test failed: Job Page is not displayed: {}", e.getMessage());
			handleTestFailure("Test failed: " + e.getMessage());
		}
	}

	@Test(groups = { "navigation" }, priority = 3)
	public void testNavigatetoInterviewResourcesPage() {
		createTest("testNavigatetoInterviewResourcesPage");
		try {
			logger.info("Starting test: testNavigatetoInterviewResourcesPage");
			test.info("Starting test: testNavigatetoInterviewResourcesPage");

			careersPage.navigateToInterviewResourcesPage();
			test.info("Navigated to the Interview Resources Page.");

			Assert.assertTrue(careersPage.isPageDisplayed(careersPage.getInterviewResourcesPage()),
					"Interview Resources Page is not displayed.");

			test.pass("Interview Resources Page is displayed successfully.");
			logger.info("Interview Resources Page is displayed successfully.");

		} catch (AssertionError e) {
			logger.error("Test failed: Interview Resources Page is not displayed: {}", e.getMessage());
			handleTestFailure("Test failed: " + e.getMessage());
		}
	}

	@Test(groups = { "navigation" }, priority = 4)
	public void testNavigatetoLifeAtFlipkartPage() {
		createTest("testNavigatetoLifeAtFlipkartPage");
		try {
			logger.info("Starting test: testNavigatetoLifeAtFlipkartPage");
			test.info("Starting test: testNavigatetoLifeAtFlipkartPage");

			careersPage.navigateToLifeAtFipkart();
			test.info("Navigated to the Life At Flipkart Page.");

			Assert.assertTrue(careersPage.isPageDisplayed(careersPage.getLifeAtFlipkartHeader()),
					"Life At Flipkart Page is not displayed.");

			test.pass("Life At Flipkart Page is displayed successfully.");
			logger.info("Life At Flipkart Page is displayed successfully.");

		} catch (AssertionError e) {
			logger.error("Test failed: Life At Flipkart Page is not displayed: {}", e.getMessage());
			handleTestFailure("Test failed: " + e.getMessage());
		}
	}

	@Test(groups = { "login", "regression" }, priority = 5)
	public void testCandidateLoginWithoutRecaptcha() throws IOException {
		createTest("testCandidateLoginWithInvalidCredentials");

		String excelFilePath = FilePaths.EXCEL_FILE_PATH;
		String sheetName = "CandidateLogin";

		List<Map<String, String>> testCases = ExcelUtils.getTestCases(excelFilePath, sheetName);

		for (Map<String, String> testCase : testCases) {
			String testCaseName = testCase.get("TestCaseName");
			String executionRequired = testCase.get("Execution Required");
			String emailId = testCase.get("Candidate Email Id");
			String password = testCase.get("Candidate Password");

			if ("Yes".equalsIgnoreCase(executionRequired)) {
				logger.info("Executing test case: " + testCaseName);
				logger.info("Candidate Email Id: " + emailId);
				logger.info("Candidate Password: " + password);

				try {
					logger.info("Starting test: testCandidateLoginWithInvalidCredentials");
					test.info("Starting test: testCandidateLoginWithInvalidCredentials");

					careersPage.candidateLoginWithoutCaptcha(emailId, password);
					test.info("Candidate trying to login with invalid credentials");

					// Assert that the error message is displayed
					Assert.assertTrue(careersPage.getCaptachRequiredMsg().isDisplayed(),
							"Captcha error message is not displayed.");
					Assert.assertEquals(careersPage.getCaptachRequiredMsg().getText(), "reCAPTCHA is required",
							"Error message text does not match.");

					test.pass("Login failed with invalid credentials and error message is displayed correctly.");
					logger.info("Login failed with invalid credentials and error message is displayed correctly.");

				} catch (AssertionError e) {
					logger.error("Test failed: Error message not displayed or incorrect: {}", e.getMessage());
					handleTestFailure("Test failed: " + e.getMessage());
				}
			}
		}
	}

	@Test(groups = { "login" }, priority = 6)  
	public void testForgotPasswordPage() {
		createTest("testForgotPasswordPage");
		try {
			logger.info("Starting test: testForgotPasswordPage");
			test.info("Starting test: testForgotPasswordPage");

			careersPage.candidateForgotPassword();
			test.info("Navigated to the Forgot Password Page.");

			Assert.assertTrue(careersPage.isPageDisplayed(careersPage.getForgotPasswordHeader()),
					"Forgot Password Page Header is not displayed.");

			test.pass("Forgot Password Page Header is displayed successfully.");
			logger.info("Forgot Password Page Header is displayed successfully.");

		} catch (AssertionError e) {
			logger.error("Test failed: Forgot Password Page Header is not displayed: {}", e.getMessage());
			handleTestFailure("Test failed: " + e.getMessage());
		}
	}
}
