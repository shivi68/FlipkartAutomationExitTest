package com.nagarro.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	private WebElement searchBar;

	@FindBy(css = "svg[width='24']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='BUOuZu']")
	private WebElement searchResult;

	@FindBy(xpath = "//a[normalize-space()='About Us']")
	private WebElement aboutUsLink;

	@FindBy(xpath = "//a[normalize-space()='About']")
	private WebElement aboutLink;

	@FindBy(xpath = "//img[@src='/assets/images/about-header-image.png']")
	private WebElement aboutUsPage;

	@FindBy(xpath = "//span[contains(text(),'Mobiles')]")
	private WebElement mobileLink;

	@FindBy(xpath = "//h1[@class='_0FYq1K']")
	private WebElement mobilePageHeader;

	public WebElement getMobilePageHeader() {
		return mobilePageHeader;
	}

	public WebElement getAboutUsPage() {
		return aboutUsPage;
	}

	// Contact Us Page Locators
	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
	private WebElement contactUsLink;

	@FindBy(css = ".ogUXNW")
	private WebElement contactUsHeader;

	public WebElement getContactUsPage() {
		return contactUsHeader;
	}

	// Locator for Become a Seller
	@FindBy(xpath = "//a[contains(text(),'Become a Seller')]")
	private WebElement becomeASellerLink;

	@FindBy(xpath = "//button[normalize-space(text())='Start Selling']")
	private WebElement startSellingButton;

	@FindBy(xpath = "//h6[normalize-space(text())='EMAIL ID & GST']")
	private WebElement sellerDashboard;

	public WebElement getSellerDashboard() {
		return sellerDashboard;
	}

	@FindBy(xpath = "//a[normalize-space()='Flipkart Stories']")
	private WebElement flipkartStoriesLink;

	@FindBy(xpath = "(//a[@class='ast-custom-button-link']/div[text()='Subscribe'])[1]")
	private WebElement subscribeFlipkartStoriesBtn;

	@FindBy(css = "h3[class='elementor-heading-title elementor-size-default']")
	private WebElement subscribeFormPage;

	public WebElement getSubscribeForm() {
		return subscribeFormPage;
	}

	@FindBy(xpath = "//span[normalize-space()='Gift Cards']")
	private WebElement giftCardsLink;

	@FindBy(css = "._0FYq1K")
	private WebElement giftCardPageHeader;

	public WebElement getGiftCardPage() {
		return giftCardPageHeader;
	}

	@FindBy(xpath = "//img[@alt='Grocery']")
	private WebElement groceryIcon;

	@FindBy(xpath = "//img[@class='W5mR4e']")
	private WebElement groceryPageHeader;

	public WebElement getGroceryPage() {
		return groceryPageHeader;
	}

	@FindBy(xpath = "//img[@alt='Cart']")
	private WebElement cartIcon;

	@FindBy(xpath = "//a[@class='wsejfv']")
	private WebElement cartPageHeader;

	public WebElement getCartPage() {
		return cartPageHeader;
	}

	@FindBy(xpath = "//a[@aria-label='Shopsy']")
	private WebElement shopsyLink;

	@FindBy(xpath = "//*[name()='path' and contains(@d,'M9.946 13.')]")
	private WebElement shopsyPageHeader;

	public WebElement getShopsyPage() {
		return shopsyPageHeader;
	}

	@FindBy(xpath = "//img[@alt='Dropdown with more help links']")
	private WebElement moreDropdown;

	@FindBy(xpath = "//li[normalize-space()='Notification Preferences']")
	private WebElement notificationPreferences;

	@FindBy(xpath = "//li[normalize-space()='Desktop Notifications']")
	private WebElement desktopNotification;

	public WebElement getNotificationPage() {
		return desktopNotification;
	}

	@FindBy(xpath = "//a[normalize-space()='Terms Of Use']")
	private WebElement termsOfUseLink;

	@FindBy(id = "flipkart-terms-of-use")
	private WebElement termsOfUsePageHeader;

	public WebElement getFlipkartTerms() {
		return termsOfUsePageHeader;
	}

	// Method to get Page Title
	public String getHomePageTitle() {
		logger.info("Getting home page title.");
		return driver.getTitle();
	}

	public void searchItem(String searchTerm) {
		logger.info("Attempting to search for the term: {}", searchTerm);
		logger.debug("Waiting for the Search Bar to be Visible and clickable.");
		getWait().waitForVisibility(searchBar);
		getWait().waitForElementToBeClickable(searchBar);
		searchBar.clear();
		searchBar.sendKeys(searchTerm);
		logger.debug("Entered the search term in the Search Bar: {}", searchTerm);
		getWait().waitForElementToBeClickable(searchButton);
		logger.debug("Clicked on the Search button for the term: {}", searchTerm);
		getWait().waitForVisibility(searchResult);
		logger.info("Search results for the term '{}' are displayed successfully.", searchTerm);
	}

	// Methods to Navigate to About Us Page
	public void navigateToAboutUsPage() {
		logger.info("Navigating to the About Us Page.");
		logger.debug("Scrolling down to locate the About Us link.");
		getScrollUtils().scrollToDown();
		logger.debug("Waiting for the 'About Us' link to be clickable.");
		getWait().waitForElementToBeClickable(aboutUsLink);
		logger.debug("Waiting for the 'About link' to be clickable.");
		getWait().waitForElementToBeClickable(aboutLink);
		logger.debug("Waiting for the 'About Us' Page header to be visible.");
		getWait().waitForVisibility(aboutUsPage);
		logger.info("Successfully navigated to the About Us Page.");
	}

	// Method to Navigate to Contact Us Page
	public void navigateToContactUsPage() {
		logger.info("Navigating to the Contact Us Page.");
		logger.debug("Scrolling down to locate the Contact Us link.");
		getScrollUtils().scrollToDown();
		logger.debug("Waiting for the 'Contact Us' link to be clickable.");
		getWait().waitForElementToBeClickable(contactUsLink);
		logger.debug("Waiting for the 'Contact Us' header to be visible.");
		getWait().waitForVisibility(contactUsHeader);
		logger.info("Successfully navigated to the Contact Us Page.");
	}

	// Method to Navigate to Become a Seller Page
	public void navigateToBecomeASellerPage() {
		logger.info("Navigating to the Become A Seller Page.");
		logger.debug("Waiting for the 'Become A Seller' link to be clickable.");
		getWait().waitForElementToBeClickable(becomeASellerLink);
		logger.debug("Waiting for the 'Start Selling' button to be clickable.");
		getWait().waitForElementToBeClickable(startSellingButton);
		logger.debug("Waiting for the Seller Dashboard to be visible.");
		getWait().waitForVisibility(sellerDashboard);
		logger.info("Successfully navigated to the Become A Seller Page.");
	}

	public void navigateToMobileLinkPage() {
		logger.info("Navigating to the Mobile Link Page.");
		logger.debug("Waiting for the Mobile Link to be clickable.");
		getWait().waitForElementToBeClickable(mobileLink);
		logger.debug("Waiting for the Mobile Page Header to be visible.");
		getWait().waitForVisibility(mobilePageHeader);
		logger.info("Successfully navigated to the Mobile Link Page.");
	}

	public void navigateToFlipkartStoriesSubscribePage() {
		logger.info("Navigating to the Flipkart Stories Subscribe Page.");
		logger.debug("Scrolling to the Flipkart Stories link.");
		getScrollUtils().scrollToElement(flipkartStoriesLink);
		logger.debug("Waiting for the Flipkart Stories link to be clickable.");
		getWait().waitForElementToBeClickable(flipkartStoriesLink);
		logger.debug("Waiting for the Subscribe Button to be visible and clickable.");
		getWait().waitForVisibility(subscribeFlipkartStoriesBtn);
		getWait().waitForElementToBeClickable(subscribeFlipkartStoriesBtn);
		logger.debug("Waiting for the Subscribe Form Page to be visible.");
		getWait().waitForVisibility(subscribeFormPage);
		logger.info("Successfully navigated to the Flipkart Stories Subscribe Page.");
	}

	public void navigateToGiftCardPage() {
		logger.info("Navigating to the Gift Card Page.");
		try {
			logger.debug("Scrolling down to locate the Gift Cards link.");
			getScrollUtils().scrollToDown();
			getWait().waitForElementToBeClickable(giftCardsLink);
			giftCardsLink.click();
			logger.debug("Waiting for the Gift Card Page header to be visible.");
			getWait().waitForVisibility(giftCardPageHeader);
			logger.info("Successfully navigated to the Gift Card Page.");
		} catch (Exception e) {
			logger.error("Failed to navigate to the Gift Card page: {}", e.getMessage(), e);
			throw e;
		}
	}

	public void navigateToGroceryPage() {
		logger.info("Navigating to the Grocery Page.");
		logger.debug("Waiting for the Grocery Icon to be clickable.");
		getWait().waitForElementToBeClickable(groceryIcon);
		logger.debug("Waiting for the Grocery Page Header to be visible.");
		getWait().waitForVisibility(groceryPageHeader);
		logger.info("Successfully navigated to the Grocery Page.");
	}

	public void clickCartIcon() {
		logger.info("Clicking on the Cart Icon.");
		logger.debug("Waiting for the Cart Icon to be clickable.");
		getWait().waitForElementToBeClickable(cartIcon);
		logger.debug("Waiting for the Cart Page Header to be visible.");
		getWait().waitForVisibility(cartPageHeader);
		logger.info("Successfully navigated to the Cart Page.");
	}

	public void navigateToShopsyPage() {
		logger.info("Navigating to the Shopsy Page.");
		logger.debug("Scrolling down to locate the Shopsy link.");
		getScrollUtils().scrollToDown();
		getWait().waitForElementToBeClickable(shopsyLink);
		switchToNewWindow("Shopsy Page");
		logger.debug("Waiting for the Shopsy Page Header to be visible.");
		getWait().waitForVisibility(shopsyPageHeader);
		logger.info("Successfully navigated to the Shopsy Page.");
	}

	public void navigateToNotificationPreferences() {
		logger.info("Navigating to Notification Preferences.");
		Actions action = new Actions(driver);
		logger.debug("Waiting for the More Dropdown to be clickable.");
		getWait().waitForElementToBeClickable(moreDropdown);
		action.moveToElement(moreDropdown).perform();
		logger.debug("Waiting for the Notification Preferences link to be visible and clickable.");
		getWait().waitForVisibility(notificationPreferences);
		getWait().waitForElementToBeClickable(notificationPreferences);
		logger.debug("Waiting for the Desktop Notification section to be visible.");
		getWait().waitForVisibility(desktopNotification);
		logger.info("Successfully navigated to Notification Preferences.");
	}

	public void navigateToTermsOfUsePage() {
		logger.info("Navigating to the Terms of Use Page.");
		logger.debug("Scrolling down to locate the Terms of Use link.");
		getScrollUtils().scrollToDown();
		getWait().waitForElementToBeClickable(termsOfUseLink);
		logger.debug("Waiting for the Terms of Use Page Header to be visible.");
		getWait().waitForVisibility(termsOfUsePageHeader);
		logger.info("Successfully navigated to the Terms of Use Page.");
	}
}
