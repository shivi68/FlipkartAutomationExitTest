package com.nagarro.flipkart.utils;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nagarro.flipkart.pages.CareersPage;
import com.nagarro.flipkart.pages.CartPage;
import com.nagarro.flipkart.pages.FlightBookingPage;
import com.nagarro.flipkart.pages.HomePage;
import com.nagarro.flipkart.pages.LoginSignUpPage;
import com.nagarro.flipkart.pages.ProductPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	protected WebDriver driver;
	protected HomePage homePage;
	protected CareersPage careersPage;
	protected ProductPage productPage;
	protected LoginSignUpPage loginPage;
	protected CartPage cartPage;
	protected FlightBookingPage flightBookingPage;
	protected ConfigReader configReader;

	// Extent Reports
	protected static ExtentReports extentReports;
	protected ExtentTest test;
	protected ExtentSparkReporter sparkReporter;

	// Log4j2 Logger
	protected static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

	@BeforeSuite
	public void setUpExtentReport() {
		if (extentReports == null) {
			sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);
			logger.info("Extent Reports initialized.");
		}
	}

	@BeforeMethod
	public void setUp() {
		try {
			configReader = new ConfigReader();

			String browser = configReader.getProperty("browser");
			boolean isHeadless = Boolean.parseBoolean(configReader.getProperty("headless"));

			logger.info("Setting up WebDriver for browser: " + browser);
			// Initialize WebDriver based on the browser
			initializeWebDriver(browser, isHeadless);

			driver.manage().window().maximize();
			String url = configReader.getProperty("url");
			if (url != null) {
				driver.get(url);
			} else {
				throw new RuntimeException("URL is not specified in the Config file.");
			}

			// Initialize Page Object Model Classes
			initializePageObjects();
			logger.info("Page objects initialized.");
		} catch (Exception e) {
			logger.error("Error during setup: " + e.getMessage(), e);
			throw e;
		}
	}

	private void initializeWebDriver(String browser, boolean isHeadless) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			if (isHeadless) {
				chromeOptions.addArguments("--headless");
			}
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			if (isHeadless) {
				fireFoxOptions.addArguments("--headless");
			}
			driver = new FirefoxDriver(fireFoxOptions);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			if (isHeadless) {
				edgeOptions.addArguments("--headless");
			}
			driver = new EdgeDriver(edgeOptions);
			break;
		default:
			logger.error("Unsupported browser specified: " + browser);
			throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
		}
	}

	private void initializePageObjects() {
		homePage = new HomePage(driver);
		careersPage = new CareersPage(driver);
		productPage = new ProductPage(driver);
		loginPage = new LoginSignUpPage(driver);
		cartPage = new CartPage(driver);
		flightBookingPage = new FlightBookingPage(driver);
	}

	// Set up a method to create a test log entry for Extent Reports
	public void createTest(String testName) {
		test = extentReports.createTest(testName);
		logger.info("Created test: " + testName);
	}

	// Capture and log errors with description in ExtentReports
	public void logError(String errorMessage) {
		test.fail(errorMessage);
		logger.error("Test failed: " + errorMessage);
		takeScreenshot(errorMessage);
	}

	// Capture screenshot with the name of the test and error description
	public String takeScreenshot(String errorMessage) {
		String screenshotPath = "";
		try {
			// Take screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//String fileName = test.getModel().getName() + "_" + errorMessage + ".png";
			String fileName = test.getModel().getName() + "_" + System.currentTimeMillis() + ".png";
			screenshotPath = "test-output/screenshots/" + fileName;
			File destFile = new File(screenshotPath);
			FileUtils.copyFile(screenshot, destFile);

			// Add screenshot to the report
			test.addScreenCaptureFromPath(destFile.getAbsolutePath(), errorMessage);
			logger.info("Screenshot taken: " + screenshotPath);
		} catch (IOException e) {
			test.fail("Failed to capture screenshot: " + e.getMessage());
			logger.error("Error capturing screenshot: " + e.getMessage());
			e.printStackTrace();
		}
		return screenshotPath;
	}

	// Custom assertion method to handle assertion and capture screenshots
	public void assertCondition(boolean condition, String errorMessage) {
		try {
			Assert.assertTrue(condition, errorMessage);
			test.log(com.aventstack.extentreports.Status.PASS, "Assertion passed.");
			logger.info("Assertion passed: " + errorMessage);
		} catch (AssertionError e) {
			test.log(com.aventstack.extentreports.Status.FAIL, "Assertion failed: " + errorMessage);
			logger.error("Assertion failed: " + errorMessage);

			// Capture the screenshot and get the path
			String screenshotPath = takeScreenshot("AssertionError_" + errorMessage.replace(" ", "_"));

			// Add screenshot to the report
			test.addScreenCaptureFromPath(screenshotPath);

			// Re-throw the error to ensure the test fails
			throw e;
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
	    if (driver != null) {
	        logger.info("Tearing down WebDriver and capturing test result.");
	        
	        if (test != null) {
	            try {
	                if (result.getStatus() == ITestResult.SUCCESS) {
	                    // Log the test as passed
	                    test.pass("Test passed successfully");
	                    logger.info("Test passed successfully.");
	                } else if (result.getStatus() == ITestResult.FAILURE) {
	                    // Log the failure reason and take a screenshot
	                    String errorMessage = result.getThrowable().getMessage();
	                    logError(errorMessage);
	                } else if (result.getStatus() == ITestResult.SKIP) {
	                    // Log the skipped test
	                    test.skip("Test skipped: " + result.getThrowable().getMessage());
	                    logger.warn("Test skipped: " + result.getThrowable().getMessage());
	                }
	            } catch (Exception e) {
	                logger.error("Error while logging test result: " + e.getMessage(), e);
	            }
	        }
	        
	        driver.quit();
	    }
	}
	
	protected void handleTestFailure(String errorMessage) {
		logError(errorMessage);
		test.fail(errorMessage);
		takeScreenshot("Failure");
		logger.error("Test failed due to AssertionError: " + errorMessage);
		Assert.fail(errorMessage);
	}

	@AfterSuite
	public void tearDownExtentReports() {
		extentReports.flush();
	}
}
