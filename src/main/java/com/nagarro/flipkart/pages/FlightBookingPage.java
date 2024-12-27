package com.nagarro.flipkart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPage extends BasePage {

	public FlightBookingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Flight Bookings')]")
	private WebElement flightBookingLink;

	@FindBy(css = "label[for='ONE_WAY'] div[class='qsHXPi']")
	private WebElement oneWayBtn;

	@FindBy(xpath = "//input[@name='0-departcity']")
	private WebElement departFrom;

	@FindBy(xpath = "//input[@name='0-arrivalcity']")
	private WebElement goingTo;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//div[@class='_1wlldp' and text()='BOM'])[1]")
	private WebElement departLocation;

	@FindBy(xpath = "(//div[@class='_1wlldp' and text()='HYD'])[2]")
	private WebElement goingLocation;

	@FindBy(xpath = "//div[@class='xTTV2S']")
	private WebElement departOn;

	@FindBy(css = ".QqFHMw.dANL6p")
	private WebElement crossReturnOn;

	@FindBy(xpath = "//div[@class='Grektq']")
	private WebElement flightsPage;

	@FindBy(xpath = "//div[@class='cPHDOP col-12-12']//div[2]//div[1]//div[4]")
	private WebElement bookFlightBtn;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement loginPage;

	public WebElement getLoginPage() {
		return loginPage;
	}

	public void flightBooking() {
		logger.info("Starting the flight booking process.");

		logger.debug("Waiting for the Flight Booking link to be clickable.");
		getWait().waitForElementToBeClickable(flightBookingLink);

		logger.debug("Waiting for the 'One Way' button to be visible and clickable.");
		getWait().waitForVisibility(oneWayBtn);
		getWait().waitForElementToBeClickable(oneWayBtn);

		logger.info("Selecting departure location.");
		logger.debug("Waiting for the 'Depart From' field to be clickable.");
		getWait().waitForElementToBeClickable(departFrom);
		logger.debug("Waiting for the 'Depart Location' to be visible and clickable.");
		getWait().waitForVisibility(departLocation);
		getWait().waitForElementToBeClickable(departLocation);

		logger.info("Selecting destination location.");
		logger.debug("Waiting for the 'Going To' field to be clickable.");
		getWait().waitForElementToBeClickable(goingTo);
		logger.debug("Waiting for the 'Going Location' to be visible and clickable.");
		getWait().waitForVisibility(goingLocation);
		getWait().waitForElementToBeClickable(goingLocation);

		logger.info("Selecting departure date.");
		logger.debug("Waiting for the 'Depart On' field to be clickable.");
		getWait().waitForElementToBeClickable(departOn);
		logger.debug("Closing the 'Return On' field if selected.");
		getWait().waitForElementToBeClickable(crossReturnOn);

		logger.info("Clicking on the Search button to find flights.");
		logger.debug("Executing JavaScript click on the 'Search' button.");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

		logger.debug("Waiting for the Flights page to be visible.");
		getWait().waitForVisibility(flightsPage);

		logger.info("Booking the flight.");
		logger.debug("Waiting for the 'Book Flight' button to be visible and clickable.");
		getWait().waitForVisibility(bookFlightBtn);
		getWait().waitForElementToBeClickable(bookFlightBtn);

		logger.info("Redirecting to the Login page for flight booking.");
		logger.debug("Waiting for the Login page to be visible.");
		getWait().waitForVisibility(loginPage);

		logger.info("Flight booking process completed successfully.");
	}
}
