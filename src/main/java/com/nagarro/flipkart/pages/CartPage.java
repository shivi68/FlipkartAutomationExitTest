package com.nagarro.flipkart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")
	private WebElement placeOrderButton;

	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}

	@FindBy(xpath = "//div[normalize-space()='Remove']")
	private WebElement removeButton;

	@FindBy(xpath = "//div[@class='gsqLM9']")
	private WebElement removeRUSureMsg;
	
	@FindBy(css = ".sBxzFz.fF30ZI.A0MXnh")
	private WebElement removeItemConfirmPopUp;

	@FindBy(xpath = "//div[@class='eIDgeN']")
	private WebElement successMsg;

	public WebElement getSuccessRemoveMsg() {
		return successMsg;
	}

	public WebElement getSaveForLaterMsg() {
		return successMsg;
	}

	@FindBy(xpath = "//div[normalize-space()='Save for later']")
	private WebElement saveForLater;
	
	@FindBy(xpath = "//div[@class='AJr9O1']")
	private WebElement youMightInterested;
	

	public void addProductToCart() {
	    logger.info("Starting the process to add the product to the cart.");
	    
	    // Zoom out using JavaScript (one line)
	    ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '90%'");

//	    getScrollUtils().scrollToElement(addToCartBtn);
//	    logger.debug("Scrolled to the 'Add to Cart' button.");
	    
	    getWait().waitForVisibility(addToCartBtn);
	    logger.debug("Waiting for the 'Add to Cart' button to be visible.");
	    
	    getWait().waitForElementToBeClickable(addToCartBtn);
	    logger.info("Clicked on the 'Add to Cart' button.");
	    
	    // Zoom in using JavaScript (one line)
	    ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '100%'");

	    getWait().waitForVisibility(placeOrderButton);
	    logger.info("Verified that the 'Place Order' button is visible, indicating the product is added to the cart.");
	}

	
	public void removeProductFromCart() {
		logger.info("Starting the process to remove the product from the cart.");
		addProductToCart();
		getScrollUtils().scrollToElement(removeButton);
		getWait().waitForVisibility(removeButton);
		getWait().waitForElementToBeClickable(removeButton);
		logger.debug("Remove Button Clicked.");
		getWait().waitForVisibility(removeRUSureMsg);
		getWait().waitForVisibility(removeItemConfirmPopUp);
		logger.debug("Revome Confirmation Pop Up Appear");
		getWait().waitForElementToBeClickable(removeItemConfirmPopUp);
		logger.debug("Clicked on Remove Button from Pop Up");
		getWait().waitForVisibility(successMsg);
		logger.info("Successfully removed the product from the cart.");
	}

	public void saveForLater() {
		addProductToCart();
		getScrollUtils().scrollToElement(saveForLater);
		getWait().waitForElementToBeClickable(saveForLater);
		getWait().waitForVisibility(successMsg);
	}
}
