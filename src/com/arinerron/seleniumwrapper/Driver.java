package com.arinerron.seleniumwrapper;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import java.util.logging.Level;

public abstract class Driver {
    // returns a WebDriver object based on the browser the caller requests
    public static WebDriver get(Browser browser) throws RuntimeException {
        WebDriver driver = null;

        // suppress irrelevant debug output
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");

        // determine operating system info to create the path and extension of drivers
        String path = "", extension = "";

        if(System.getProperty("os.name").startsWith("Windows")) {
            path = "windows";
            extension = ".exe";
        } else {
            path = "linux";
        }

        path += "/" + System.getProperty("sun.arch.data.model");

        Logger.debug("Operating system and architecture determined to be \"" + path + "\".");

        // create the WebDriver
        switch(browser) {
            case FIREFOX:
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            System.setProperty("webdriver.gecko.driver", "../lib/drivers/" + path + "/geckodriver" + extension);
            driver = new FirefoxDriver();
            break;

            case CHROME:
            System.setProperty("webdriver.chrome.driver", "../lib/drivers/" + path + "/chromedriver" + extension);
            driver = new ChromeDriver();
            break;

            default:
            Logger.warn("Failed to determine browser; could not instantiate WebDriver.");
            return null;

        }

        return driver;
    }
}
