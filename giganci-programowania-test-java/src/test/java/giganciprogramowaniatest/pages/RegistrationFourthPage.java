package giganciprogramowaniatest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import giganciprogramowaniatest.utilities.Driver;

public class RegistrationFourthPage {

    // Locators
    @FindBy(id = "registration-step-submit")
    WebElement submitButton;

    @FindBy(className = "registration-btn")
    List<WebElement> registrationButtons;

    @FindBy(className = "timetable__date-places-info")
    List<WebElement> registrationVacancies;

    @FindBy(name = "student_firstname")
    WebElement firstName;

    @FindBy(name = "student_lastname")
    WebElement lastName;

    @FindBy(name = "lastname")
    WebElement parentLastName;

    @FindBy(name = "zip_code")
    WebElement zipCode;

    public RegistrationFourthPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void inputZipCode(String code) {
        zipCode.sendKeys(code);
    }

    public void inputParentLastName(String name) {
        parentLastName.sendKeys(name);
    }

    public void inputStudentLastName(String name) {
        lastName.sendKeys(name);
    }

    public void inputStudentFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void selectCourseDateNotInStandbyList() {
        WebDriver driver = Driver.getDriver();
        // Set up explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
        try {
            WebElement wybierzButton = registrationButtons.get(0);
            
            // Waits for the element to be visible after dynamic reload
            wait.until(ExpectedConditions.stalenessOf(wybierzButton));  // Waits for the old element to be stale
            
            // Relocates the element
            wybierzButton = registrationButtons.get(0);
    
            wait.until(ExpectedConditions.visibilityOf(wybierzButton)); // Checks if it's visible
            wait.until(ExpectedConditions.elementToBeClickable(wybierzButton)); // Checks if it's clickable
            
            // Iterates trough available course dates
            for (int i = 0; i < registrationButtons.size(); i++) {
                WebElement button = registrationButtons.get(i);
                WebElement vacancy = registrationVacancies.get(i);
                
                if (!vacancy.getText().contains("Zapisy na listę rezerwową")) {
                    button.click();
                    break; // Exits the loop after finding first matching date
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
