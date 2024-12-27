package com.nagarro.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSignUpPage extends BasePage {

	public LoginSignUpPage(WebDriver driver) {
		super(driver);
	}

	// Login
	@FindBy(xpath = "//span[normalize-space()='Login']")
	private WebElement loginBtn;

	@FindBy(css = "input[class='r4vIwl BV+Dqf']")
	private WebElement phoneField;

	@FindBy(xpath = "//button[normalize-space()='Request OTP']")
	private WebElement requestOtpButton;

	@FindBy(xpath = "//div[normalize-space()='Please enter the OTP sent to']")
	private WebElement otpSentHeader;

	public WebElement getLoginOtpPage() {
		return otpSentHeader;
	}

	public void verifyOtpSentSuccessfully(String phone) {
		logger.info("Starting the OTP verification process.");

		logger.debug("Waiting for the Login button to be clickable.");
		getWait().waitForElementToBeClickable(loginBtn);

		logger.info("Entering the phone number: {}", phone);
		logger.debug("Waiting for the Phone Field to be visible and clickable.");
		getWait().waitForVisibility(phoneField);
		getWait().waitForElementToBeClickable(phoneField);
		phoneField.sendKeys(phone);
		logger.debug("Phone number entered successfully.");

		logger.info("Requesting OTP.");
		logger.debug("Waiting for the 'Request OTP' button to be clickable.");
		getWait().waitForElementToBeClickable(requestOtpButton);

		logger.info("Verifying OTP sent header.");
		logger.debug("Waiting for the 'OTP Sent' header to be visible.");
		getWait().waitForVisibility(otpSentHeader);

		logger.info("OTP sent successfully for the phone number: {}", phone);
	}
}
