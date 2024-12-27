package com.nagarro.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	// Locator
	@FindBy(xpath = "//span[@class='BUOuZu']")
	private WebElement searchResult;

	public WebElement getSearchResult() {
		return searchResult;
	}

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]")
	private WebElement productCard;

	@FindBy(xpath = "//span[@class='VU-ZEz']")
	private WebElement productDetailsPage;
	
	@FindBy(xpath = "//input[@id='pincodeInputId']")
	private WebElement pinCode;
	
	@FindBy(css = ".i40dM4")
	private WebElement pinCodeCheckBtn;
	
	@FindBy(css = ".nyRpc8")
	private WebElement invalidPinCodeMsg;
	
	public WebElement getInvalidPinCodeMsg() {
		return invalidPinCodeMsg;
	}

	public WebElement getProductDetails() {
		return productDetailsPage;
	}

	public void searchedItemPage() {
		logger.info("Navigating to the searched items page.");
		logger.debug("Waiting for the search results to be visible.");
		getWait().waitForVisibility(searchResult);
		logger.info("Search results displayed successfully.");
	}

	public void navigateToProductDetailsPage() {
		logger.info("Navigating to the product details page.");

		logger.debug("Waiting for the product card to be visible.");
		getWait().waitForVisibility(productCard);

		logger.debug("Waiting for the product card to be clickable.");
		getWait().waitForElementToBeClickable(productCard);

		logger.info("Switching to the new window for the Product Page.");
		switchToNewWindow("Product Page");

		logger.debug("Scrolling to the product details section.");
		getScrollUtils().scrollToElement(productDetailsPage);

		logger.debug("Waiting for the product details page to be visible.");
		getWait().waitForVisibility(productDetailsPage);

		logger.info("Successfully navigated to the product details page.");
	}
	
	public void verifyPinCode(String pincode) {
		getWait().waitForVisibility(pinCode);
		getWait().waitForElementToBeClickable(pinCode);
		pinCode.sendKeys(pincode);
		getWait().waitForElementToBeClickable(pinCodeCheckBtn);
		getWait().waitForVisibility(invalidPinCodeMsg);
	}
}
