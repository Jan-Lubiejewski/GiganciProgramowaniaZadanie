package giganciprogramowaniatest.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    // Is ran before each scenario, sets up the driver and visit url
    @Before
    public void setUp() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://devtest.giganciprogramowania.edu.pl/zapisz-sie");
    }

    // Is ran after each scenario, quits the driver
    @After
    public void tearDown() {
        try {
            Thread.sleep(5000); // For debugging purposes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.quitDriver(); 
    }
}

