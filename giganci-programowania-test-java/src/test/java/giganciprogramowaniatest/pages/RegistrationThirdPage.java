package giganciprogramowaniatest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import giganciprogramowaniatest.utilities.Driver;

public class RegistrationThirdPage {

    // Locators
    @FindBy(name = "registration-step-select-course-1092")
    WebElement wybierzButtonPierwszeKrokiWProgramowniu;
    
    public RegistrationThirdPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickOnWybierzPierwszeKrokiWProgramowaniu() {
        WebDriver driver = Driver.getDriver();
        // Set up explicit wait for up to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement wybierzButton = wybierzButtonPierwszeKrokiWProgramowniu;
    
        try {
            // Wait until the button is visible and clickable
            wait.until(ExpectedConditions.visibilityOf(wybierzButton));
            wait.until(ExpectedConditions.elementToBeClickable(wybierzButton));
    
            wybierzButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
