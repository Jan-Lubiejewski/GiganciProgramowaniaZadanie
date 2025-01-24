package giganciprogramowaniatest.pages;

import giganciprogramowaniatest.utilities.Driver;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class RegistrationFirstPage {

    // Locators
    @FindBy(id = "submit-payment")
    WebElement form;
    
    @FindBy(name = "parentName")
    WebElement parentName;
    @FindBy(xpath = "//input[@name='parentName']/ancestor::div[@class='formControls']//span[@class='formValidation']")
    WebElement parentNameError;

    @FindBy(name = "email")
    WebElement email;
    @FindBy(xpath = "//input[@name='email']/ancestor::div[@class='formControls']//span[@class='formValidation']")
    WebElement emailError;

    @FindBy(name="phoneNumber")
    WebElement phoneNumber;
    @FindBy(xpath = "//input[@name='phoneNumber']/ancestor::div[@class='formControls']//span[@class='formValidation']")
    WebElement phoneNumberError;

    @FindBy(name = "birthYear")
    WebElement birthYear;
    @FindBy(xpath = "//input[@name='birthYear']/ancestor::div[@class='formControls']//span[@class='formValidation']")
    WebElement birthYearError;

    @FindBy(id = "statuteAgreed")
    WebElement statueAgreed;
    @FindBy(xpath = "//input[@id='statuteAgreed']/parent::div//div[@class='formValidation']//span[@class='formError']")
    WebElement statueAgreedError;

    @FindBy(id = "advertisementAgreed")
    WebElement advertisementAgreed;
    @FindBy(xpath = "//input[@id='advertisementAgreed']/parent::div//div[@class='formValidation']//span[@class='formError']")
    WebElement advertisementAgreedError;

    @FindBy(xpath = "//h4[@class='alert-heading']")
    WebElement alertMessage;

    @FindBy(id = "agreement-step-submit")
    WebElement dalejButton;

    // Initialize the web elements of the page using PageFactory
    public RegistrationFirstPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void checkAdvertisementAgreed() {
        // Executes JavaScript code to click the checkbox as the selenium built-in click is intercepted by label
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", advertisementAgreed);
    }

    public void checkStatueAgreedCheckbox() {
        // Executes JavaScript code to click the checkbox as the selenium built-in click is intercepted by label
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", statueAgreed);
    }

    public void inputBirthYear(String year) {
        birthYear.sendKeys(year);
    }

    public void inputParentName(String name) {
        parentName.sendKeys(name);
    }

    // Checks if the phone format Error appears and if the error texts equals expected text
    public boolean isErrorPhoneFormatAppears() {
        String expectedText = "Niepoprawny numer telefonu. Numer powinien zawierać 9 cyfr, z opcjonalnym kierunkowym +48 lub +380 na początku.";
        if(phoneNumberError.isDisplayed() 
        && phoneNumberError.getText().equals(expectedText)) {
            return true;
        } else {
            return false;
        }
    }

    public void inputPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
    }

    // Checks if the email format Error appears and if the error texts equals expected text
    public boolean isErrorEmailFormatAppears() {
        String expectedText = "Nieprawidłowy adres e-mail";
        if(emailError.isDisplayed() && emailError.getText().equals(expectedText)) {
            return true;
        } else {
            return false;
        }
    }

    public void inputEmail(String mail) {
        email.sendKeys(mail);
    }

    // Checks if url stays the same and the form from first page is displayed 
    public boolean isRemainAtFirstRegistrationPage() {
        String expectedUrl = "https://devtest.giganciprogramowania.edu.pl/zapisz-sie";
        String currentUrl = Driver.getDriver().getCurrentUrl(); // Retrieves current url from browser
        if (form.isDisplayed() && currentUrl.equals(expectedUrl)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlertMessageAppears() {
        boolean isDisplayed = alertMessage.isDisplayed();
        return isDisplayed;
    }

    public boolean isFormSubmitted() {
        // If the original form is displayed then the form hasn't been submitted
        boolean isSubmitted = !(form.isDisplayed());
        return isSubmitted;
    }

    // Checks if each error appears when fields are left empty
    public boolean isErrorMessageAppearsUnderAllFields() {
        boolean isDisplayed = false;

        // Creates list of WebElement errors to iterate trough
        List<WebElement> errorMessages = Arrays.asList(
            parentNameError,
            emailError,
            phoneNumberError,
            birthYearError,
            statueAgreedError,
            advertisementAgreedError
            );
        // Iterate trough each errorMessage and check if it's displayed correctly
        for (WebElement errorMessage : errorMessages) {
            if(errorMessage.isDisplayed() && 
            (errorMessage.getText().equals("Pole jest wymagane") || errorMessage.getText().equals("To pole jest wymagane"))) {
                isDisplayed = true;
            } else {
                isDisplayed = false;
            }
        }
        return isDisplayed;
    }

    public void clickDalej() {
        dalejButton.click();
    }

}
