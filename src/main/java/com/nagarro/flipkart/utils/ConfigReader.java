package com.nagarro.flipkart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	
	protected static final Logger logger = LogManager.getLogger(ConfigReader.class);
	private Properties properties;
	
    public ConfigReader() {
    	properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fileInputStream);
            logger.info("Configuration file loaded successfully.");
        } catch (IOException e) {
        	logger.error("Failed to load properties file.", e);
        	throw new RuntimeException("Failed to load properties file.", e);
        }
    }

    // Get the value of any property from the config file
    public String getProperty(String key) {
        String value =  properties.getProperty(key);
        if (value != null) {
            logger.info("Retrieved property [{}] with value [{}].", key, value);
        } else {
            logger.warn("Property [{}] not found in the configuration file.", key);
        }
        return value;
    }
    
    
    // Get global wait time from the config file as a non-static method
    public int getGlobalWaitTime() {
        try {
            int waitTime = Integer.parseInt(getProperty("globalWaitTime"));
            logger.info("Global wait time set to [{}] seconds.", waitTime);
            return waitTime;
        } catch (NumberFormatException | NullPointerException e) {
        	int defaultWaitTime = 10; // Default wait time
            logger.warn("Failed to retrieve or parse globalWaitTime. Using default value [{}].", defaultWaitTime);
            throw e;
        }
    }	
    
    //Method to get the expected home page title
    public String getExpectedHomePageTitle() {
        return getProperty("expectedHomePageTitle");
    }
  
}
    