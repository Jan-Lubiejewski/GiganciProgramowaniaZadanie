package giganciprogramowaniatest.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import giganciprogramowaniatest.utilities.Driver;

public class RegistrationSecondPage {

    // Locators
    @FindBy(xpath = "//span[text()='Wybierz tematykę kursu']")
    WebElement formHeading;

    @FindBy(className = "feature_registration-menu__item-icon")
    List<WebElement> steps;

    @FindBy(className = "js-kind-group")
    List<WebElement> courseTopic;

    @FindBy(xpath = "//button[text()='Online']")
    WebElement onlineButton;

    @FindBy(className = "sub-kind-selector--button")
    List<WebElement> courseType;


    
    public RegistrationSecondPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickRoczneKursyZProgramowania() {
        WebDriver driver = Driver.getDriver();
        // Set up explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // First button is Roczne Kursy Z Programowania 
        WebElement roczneKursyButton = courseType.get(0);
    
        try {
            // Wait until the button is visible and clickable
            wait.until(ExpectedConditions.visibilityOf(roczneKursyButton));
            wait.until(ExpectedConditions.elementToBeClickable(roczneKursyButton));
    
            roczneKursyButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnline() {
        WebDriver driver = Driver.getDriver();
        // Set up explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
        try {
            // Wait until the button is visible and clickable
            wait.until(ExpectedConditions.visibilityOf(onlineButton));
            wait.until(ExpectedConditions.elementToBeClickable(onlineButton));
    
            onlineButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickProgramowanie() {
        courseTopic.get(1).click();
    }
    // If customer has moved to second Page the formheading should be visible
    public boolean isMoveToSecondRegistrationPage() {
        WebDriver driver = Driver.getDriver();
        // Set up explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait until the heading is visible and check if it's being displayed
            wait.until(ExpectedConditions.visibilityOf(formHeading));
            return formHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFirstStepTicked() {
        WebElement firstStep = steps.get(0);
        
        // Retrieves the parent element that contains the information if the step is completed
        WebElement parentElement = firstStep.findElement(By.xpath(".."));
        // Retrieves the child element that contains the tick svg icon
        WebElement childElement = firstStep.findElement(By.tagName("svg"));
        
        String parentClass = parentElement.getAttribute("class");
        String childClass = childElement.getAttribute("class");
        // Checks if the classes of given element contains Completed and Icon-Tick class
        if (parentClass.contains("feature_registration-menu__item--completed") && childClass.contains("icon-tick")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSecondStepActive() {
        WebElement secondStep = steps.get(1);
        // Retrieves parent element that contains class info if the class is active
        WebElement parentElement = secondStep.findElement(By.xpath(".."));
        
        String parentClass = parentElement.getAttribute("class");
        // Checks if the classes of elements contains Active class
        if (parentClass.contains("feature_registration-menu__item--active")) {
            return true;
        } else {
            return false;
        }
    }
}
