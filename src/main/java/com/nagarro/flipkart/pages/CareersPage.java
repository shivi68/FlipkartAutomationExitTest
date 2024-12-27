package com.nagarro.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {

	// Constructor
	public CareersPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	// a[@aria-label='Careers']
	@FindBy(xpath = "//a[@aria-label='Careers']")
	private WebElement careersLink;

	@FindBy(css = ".logo_career_text")
	private WebElement careersPageHeader;

	public WebElement getCareersPageHeader() {
		return careersPageHeader;
	}

	@FindBy(css = ".dropdown-toggle[href='javascript:void(0)']")
	private WebElement jobsDropdown;

	@FindBy(xpath = "//a[@href='#!/joblist' and contains(@style, 'color: #333')]")
	private WebElement jobListLink;

	@FindBy(xpath = "//h3[@class='inner-head']")
	private WebElement currentOpeningHeader;

	public WebElement getCurrentOpeningHeader() {
		return currentOpeningHeader;
	}

	@FindBy(xpath = "//p[@class='f-16 wow fadeInUp']")
	private WebElement numberOfCurrentOpeningsJob;

	@FindBy(xpath = "//a[@data-hover='dropdown']")
	private WebElement interviewingAtFlipkartLink;

	@FindBy(xpath = "//ul[@class='dropdown-menu custom-menu custom-menu-1']//a[normalize-space()='Interview Resources']")
	private WebElement interviewResourcesLink;

	@FindBy(xpath = "//h1[text() = \"Interview Resources\"]")
	private WebElement interviewResourcesPageHeader;

	public WebElement getInterviewResourcesPage() {
		return interviewResourcesPageHeader;
	}

	@FindBy(xpath = "//a[normalize-space()='Life At Flipkart']")
	private WebElement lifeAtFlipkartLink;

	@FindBy(xpath = "//span[span[contains(text(), 'Life @')]]")
	private WebElement lifeAtFlipkartHeader;

	public WebElement getLifeAtFlipkartHeader() {
		return lifeAtFlipkartHeader;
	}

	// Locators for Candidate Login
	@FindBy(id = "candidate-login-before")
	private WebElement candidateLoginLink;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement candidateEmailId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement candidatePassword;

	@FindBy(xpath = "//span[contains(text(),'reCAPTCHA is required')]")
	private WebElement recaptchaRequiredMsg;

	@FindBy(id = "loginbtn")
	private WebElement candidateLoginBtn;

	public WebElement getCaptachRequiredMsg() {
		return recaptchaRequiredMsg;
	}

	@FindBy(css = ".forgot_password.f-14")
	private WebElement candidateForgotPasswordLink;

	@FindBy(xpath = "//h2[text() = 'Forgot Password']")
	private WebElement forgotPasswordHeader;

	public WebElement getForgotPasswordHeader() {
		return forgotPasswordHeader;
	}

	public void navigateToCareersPage() {
		logger.debug("Scrolling down to locate the Shopsy link.");
		getScrollUtils().scrollToDown();
		logger.debug("Waiting for the Careers link to be clickable");
		getWait().waitForElementToBeClickable(careersLink);
		logger.info("Navigated to the Careers Page");
		getWait().waitForVisibility(careersPageHeader);
	}

	// Navigating to the Jobs Opening Page
	public void navigateToJobsPage() {
		logger.info("Navigating to the Jobs Opening Page.");
		navigateToCareersPage();
		logger.debug("Hovering over the Jobs dropdown.");
		Actions actions = new Actions(driver);
		getWait().waitForVisibility(jobsDropdown);
		actions.moveToElement(jobsDropdown).perform();
		logger.debug("Waiting for the Job List link to be visible and clickable.");
		getWait().waitForVisibility(jobListLink);
		getWait().waitForElementToBeClickable(jobListLink);
		logger.info("Navigated to the Jobs Opening Page successfully.");
		getWait().waitForVisibility(currentOpeningHeader);
	}

	public void navigateToInterviewResourcesPage() {
		logger.info("Navigating to the Interview Resources Page.");
		navigateToCareersPage();
		Actions action = new Actions(driver);
		logger.debug("Hovering over the 'Interviewing at Flipkart' link.");
		getWait().waitForElementToBeClickable(interviewingAtFlipkartLink);
		action.moveToElement(interviewingAtFlipkartLink).perform();
		logger.debug("Waiting for the Interview Resources link to be visible and clickable.");
		getWait().waitForVisibility(interviewResourcesLink);
		getWait().waitForElementToBeClickable(interviewResourcesLink);
		logger.info("Navigated to the Interview Resources Page successfully.");
		getWait().waitForVisibility(interviewResourcesPageHeader);
	}

	public void navigateToLifeAtFipkart() {
		logger.info("Navigating to the Life at Flipkart Page.");
		navigateToCareersPage();
		logger.debug("Waiting for the 'Life at Flipkart' link to be visible and clickable.");
		getWait().waitForVisibility(lifeAtFlipkartLink);
		getWait().waitForElementToBeClickable(lifeAtFlipkartLink);
		logger.info("Navigated to the Life at Flipkart Page successfully.");
		getWait().waitForVisibility(lifeAtFlipkartHeader);
	}

	public void candidateLoginWithoutCaptcha(String emailId, String password) {
		logger.info("Attempting candidate login without CAPTCHA.");
		navigateToCareersPage();
		logger.debug("Waiting for the Candidate Login link to be visible and clickable.");
		getWait().waitForVisibility(candidateLoginLink);
		getWait().waitForElementToBeClickable(candidateLoginLink);
		logger.debug("Entering email ID: {}", emailId);
		getWait().waitForVisibility(candidateEmailId);
		getWait().waitForElementToBeClickable(candidateEmailId);
		candidateEmailId.sendKeys(emailId);
		logger.debug("Entering password.");
		getWait().waitForVisibility(candidatePassword);
		getWait().waitForElementToBeClickable(candidatePassword);
		candidatePassword.sendKeys(password);
		logger.debug("Clicking the Candidate Login button.");
		getWait().waitForElementToBeClickable(candidateLoginBtn);
		logger.info("Verifying CAPTCHA requirement message visibility.");
		getWait().waitForVisibility(recaptchaRequiredMsg);
	}

	public void candidateForgotPassword() {
		logger.info("Navigating to the Candidate Forgot Password Page.");
		navigateToCareersPage();
		logger.debug("Waiting for the Candidate Login link to be clickable.");
		getWait().waitForElementToBeClickable(candidateLoginLink);
		logger.debug("Waiting for the Candidate Forgot Password link to be clickable.");
		getWait().waitForElementToBeClickable(candidateForgotPasswordLink);
		logger.info("Navigated to the Candidate Forgot Password Page successfully.");
		getWait().waitForVisibility(forgotPasswordHeader);
	}
}
