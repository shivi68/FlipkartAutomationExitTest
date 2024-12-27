package com.nagarro.flipkart.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final Logger logger = LogManager.getLogger(WaitUtils.class);

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int globalWaitTime) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(globalWaitTime));
        logger.info("WaitUtils initialized with a global wait time of {} seconds.", globalWaitTime);
    }

    public void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element is visible: {}", element);
        } catch (Exception e) {
            logger.error("Element not visible: {}", element, e);
            throw e;
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            logger.info("Element is clickable: {}", element);
        } catch (Exception e) {
            logger.error("Element not clickable: {}", element, e);
            throw e;
        }
    }
}
