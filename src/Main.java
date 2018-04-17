/*
 * This class is used to test the wrapper. Packaged versions of this wrapper
 * should not contain this class.
 */

import com.arinerron.seleniumwrapper.*;
import org.openqa.selenium.*;

public class Main {
    public static void main(String[] args) {
        // initialize WebDriver
        WebDriver driver = null;
        try {
            Logger.info("Initializing WebDriver...");
            driver = Driver.get(Browser.FIREFOX);
        } catch(Exception e) {
            handle("Failed to initialize WebDriver.", e);
            System.exit(1);
        }

        // test fetching pages
        try {
            // fetch arinerron.com
            Logger.info("Performing test: Webpage Fetching");
            driver.get("https://www.arinerron.com/");

            // check if title is set properly
            String correctTitle = "Arinerron";
            if(!correctTitle.equals(driver.getTitle())) {
                handle("Title \"" + driver.getTitle() + "\" does not match predefined title \"" + correctTitle + "\".", null);
            }
        } catch(Exception e) {
            handle("Failed to perform webpage fetching test.", e);
        }

        driver.close();
        Logger.info("Tests complete.");
    }

    public static void handle(Object message, Exception e) {
        Logger.warn("Error: " + message);
        if(e != null)
            e.printStackTrace();
    }
}
