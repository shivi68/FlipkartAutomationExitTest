
# FlipkartAutomationTesting
This project automates various scenarios on Flipkart's website using Selenium WebDriver and Java. The framework follows the Page Object Model (POM) design pattern and utilizes Maven for project management.

**Table of Contents**

- #prerequisites
- #installation
- #configuration
- #running-the-tests
- #viewing-the-reports
- #project-structure
- #test-scenarios
- #troubleshooting

**Prerequisites**

Ensure you have the following software installed:

- Java Development Kit (JDK 8) or later: Download from (link unavailable)
- Apache Maven: Used for dependency management. (link unavailable)
- IDE (e.g., IntelliJ, Eclipse): Recommended for easier development and debugging
- Selenium WebDriver: Included as a Maven dependency

**Installation**

1. Download the Flipkart Automation Testing project zip file from OneDrive: [insert OneDrive link]
2. Extract the zip file to a directory (e.g., Flipkart-automation-testing)
3. Open Eclipse:
	  File > Import > Existing Projects into Workspace
    - Select the extracted project directory (Flipkart-automation-testing)
    - Click Finish
4. Verify Maven configuration:
    - Right-click project > Maven > Update Project
    - Ensure Maven dependencies are resolved
5. Run the project:
    - Right-click project > Run As > Maven test

**Configuration**

Configure the following files:

- config.properties: Update application URL, browser name, and global wait time and Update test data(e.g., username, password)


**Running the Tests**

-- Using Command Line

1. Run all tests: mvn clean test
2. Run specific test class: mvn clean test -Dtest=TestClass1
3. Run tests in headless mode: mvn clean test -headless.mode=true
4. Specify browser: mvn clean test -browser.name=chrome

Eclipse

1. Run all tests in a class:
    - Right-click on the test class
    - Select "Run As" > "TestNG Test"
2. Run all tests with Extent Report:
    - Right-click on testng.xml
    - Select "Run As" > "TestNG Suite"

**Extent the Reports**

-- Extent Reports are generated in test-output/ExtentReport.html
- Screenshots are captured for failed test cases in test-output/screenshots/


**Logger Implementation**

- Log4j is used for logging.
- Log files are generated in target/logs directory.

**Project Structure**

- src/main/java: Page classes and utility classes
- src/main/resources: Configuration files with all test data
- src/test/java: Test classes for each Page Classes
- test-output: Extent Report directory and Screenshots

**Test Scenarios**

1) About Page Test 
2) Add Item To Cart Page Test
3) Become A Seller Page Test
4) Careers Page Test 
5) Contact Page Test
6) Flight Booking Test
7) Flipkart Subscribe Test
8) Gift Cards Test
9) Grocery Page Test 
10) Home Page Test
11) Login Account Page
12) Mobile Page Test
13) Navigate To Cart Page Test
14) Notification Page Test
15) Pin Code Test
16) Product Details Test
17) Remove Item From Cart Test
18) Save For Later Test
19) Search Item Test
20) Shopsy New SIte Page Test
21) Terms Of Use Page Test

--> Test Data

- Test data is stored in testData.xsls file.
- Update testData.xsls to modify test data.


**Troubleshooting**

- Verify WebDriver versions match browser versions
- Check configuration files for correct values
- Review Extent Reports for error details

