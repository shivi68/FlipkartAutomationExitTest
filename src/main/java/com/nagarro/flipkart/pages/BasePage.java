package com.nagarro.flipkart.pages;

import com.nagarro.flipkart.utils.ConfigReader;
import com.nagarro.flipkart.utils.ScrollUtils;
import com.nagarro.flipkart.utils.WaitUtils;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected static final Logger logger = LogManager.getLogger(BasePage.class);

	protected WebDriver driver;
	protected ConfigReader configReader;
	protected WaitUtils waitUtils;
	protected ScrollUtils scrollUtils;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.configReader = new ConfigReader();
		try {
			logger.debug("Initializing utility classes for BasePage.");
			int globalWaitTime = configReader.getGlobalWaitTime();
			this.waitUtils = new WaitUtils(driver, globalWaitTime);
			this.scrollUtils = new ScrollUtils(driver);
			logger.info("BasePage initialized with utility classes.");
		} catch (Exception e) {
			logger.error("Error initializing utility classes: {}", e.getMessage());
			throw e;
		}

		// Initialize page elements using PageFactory
		logger.debug("Initializing page elements using PageFactory.");
		PageFactory.initElements(driver, this);
		logger.info("Page elements successfully initialized using PageFactory.");
	}

	// Reusable Method to Check Page Displayed
	public boolean isPageDisplayed(WebElement pageElement) {
		try {
			logger.debug("Checking if the page element is displayed.");
			getWait().waitForVisibility(pageElement);
			logger.info("The page is displayed.");
			return true;
		} catch (Exception e) {
			logger.error("The page is not displayed.", e);
			return false;
		}
	}

	public WaitUtils getWait() {
		logger.debug("Returning WaitUtils instance.");
		return waitUtils;
	}

	public ScrollUtils getScrollUtils() {
		logger.debug("Returning ScrollUtils instance.");
		return scrollUtils;
	}

	public void switchToNewWindow(String windowTitle) {
		try {
			logger.debug("Switching to new window with title: {}", windowTitle);
			String originalWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();

			boolean windowFound = false;

			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					logger.info("Switched to new window: {}", driver.getTitle());

					if (driver.getTitle().equals(windowTitle)) {
						  logger.info("Successfully found and switched to the target window: {}", windowTitle);
						windowFound = true;
						break;
					}
				}
			}

			if (!windowFound) {
				logger.warn("Window with title '{}' not found.", windowTitle);
			}
		} catch (Exception e) {
			logger.error("Error while switching to the window: {}", e.getMessage(), e);
			throw e;
		}
	}

}
