package giganciprogramowaniatest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import giganciprogramowaniatest.utilities.Driver;

public class RegistrationFifthPage {

    //Locators
    @FindBy(xpath = "//div[@class='registration-form-agreement-content-thanks mb-24']/span")
    WebElement agreementHeading;

    @FindBy(className = "feature_registration-menu__item-icon")
    List<WebElement> steps;

    // Initialize the web elements of the page using PageFactory
    public RegistrationFifthPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

public boolean isStepsUpToFifthCompleted() {
    boolean isDisplayed = false;
    // Iterates through the steps list except for the last two
    for (int i = 0; i < steps.size() - 2; i++) {
        WebElement firstStep = steps.get(i);

        // Retrieves the parent element that contains the information if the step is completed
        WebElement parentElement = firstStep.findElement(By.xpath(".."));
        // Retrieves the child element (svg icon)
        WebElement childElement = firstStep.findElement(By.tagName("svg"));

        String parentClass = parentElement.getAttribute("class");
        String childClass = childElement.getAttribute("class");

        // Checks if the classes of given element contains Completed and Icon-Tick class
        if (parentClass.contains("feature_registration-menu__item--completed") && 
            childClass.contains("icon-tick")) {
            isDisplayed = true;
        } else{
            isDisplayed = false;
            break;
        }
    }
    return isDisplayed;
}

    // If customer has moved to fifth Page the agreementHeading should be visible
    public boolean isMoveToFifthRegistrationPage() {
        WebDriver driver = Driver.getDriver();
        // Set up explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait until the heading is visible and check if it's being displayed
            wait.until(ExpectedConditions.visibilityOf(agreementHeading));
            return agreementHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
