package com.nagarro.flipkart.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {

    private static final Logger logger = LogManager.getLogger(ScrollUtils.class);
    private WebDriver driver;

    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
    }
    
    public void scrollToTop() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0);");
            logger.info("Scrolled to the top of the page.");
        } catch (Exception e) {
            logger.error("Failed to scroll to the top of the page: {}", e.getMessage(), e);
            throw e;
        }
    }
    
    public void scrollToDown() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            logger.info("Scrolled to the bottom of the page.");
        } catch (Exception e) {
            logger.error("Failed to scroll to the bottom of the page: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Execute the JavaScript to scroll to the element
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", element);
            logger.info("Scrolled to element: {}", element);
        } catch (JavascriptException jsEx) {
            logger.error("JavaScript error while scrolling to element: {}", jsEx.getMessage(), jsEx);
            throw jsEx;
        } catch (Exception e) {
            logger.error("Failed to scroll to element: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void scrollBy(int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
            logger.info("Scrolled by x: {}, y: {}", x, y);
        } catch (Exception e) {
            logger.error("Failed to scroll by x: {}, y: {}", x, y, e);
            throw e;
        }
    }
}
