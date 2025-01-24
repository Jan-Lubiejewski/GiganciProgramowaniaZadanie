package giganciprogramowaniatest.steps.registration;

import org.junit.Assert;

import giganciprogramowaniatest.pages.RegistrationFifthPage;
import giganciprogramowaniatest.pages.RegistrationFirstPage;
import giganciprogramowaniatest.pages.RegistrationFourthPage;
import giganciprogramowaniatest.pages.RegistrationSecondPage;
import giganciprogramowaniatest.pages.RegistrationThirdPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegistrationSteps {
    RegistrationFirstPage registrationFirstPage;
    RegistrationSecondPage registrationSecondPage;
    RegistrationThirdPage registrationThirdPage;
    RegistrationFourthPage registrationFourthPage;
    RegistrationFifthPage registrationFifthPage;

    @Given("I am on the first step of the Registration Form")
    public void i_am_on_the_first_registration_form() {
        registrationFirstPage = new RegistrationFirstPage();
    }
    @Then("I submit the form by clicking 'Dalej' button once.")
    public void i_click_dalej_button() {
        registrationFirstPage.clickDalej();
        registrationSecondPage = new RegistrationSecondPage();
    }

    @Then("Validation message 'Pole jest wymagane' displays under each required field")
    public void error_message_appears_under_input_fields() {
        boolean isErrorMessageAppears = registrationFirstPage.isErrorMessageAppearsUnderAllFields();
        Assert.assertTrue(isErrorMessageAppears);
    }

    @And("Form has not been submitted")
    public void form_not_submitted() {
        boolean isFormSubmitted = registrationFirstPage.isFormSubmitted();
        Assert.assertFalse(isFormSubmitted);
    }

    @And("Red colored alert appears with following text 'Prosimy uzupełnić wszystkie wymagane pola.'")
    public void red_alert_appears() {
        boolean isAlertAppears = registrationFirstPage.isAlertMessageAppears();
        Assert.assertTrue(isAlertAppears);
    }

    @And("Customer remains at first step of registration form")
    public void remain_at_first_registration_page() {
        boolean isRemainAtFirstRegistrationPage = registrationFirstPage.isRemainAtFirstRegistrationPage();
        Assert.assertTrue(isRemainAtFirstRegistrationPage);
    }

    @Then("I fill email input with {string}")
    public void input_email(String email) {
        registrationFirstPage.inputEmail(email);
    }

    @Then("Validation message 'Nieprawidłowy adres e-mail' displays under 'Adres e-mail' input.")
    public void email_wrong_format_error_message_appears() {
        boolean isEmailWrongFormatErrorAppears = registrationFirstPage.isErrorEmailFormatAppears();
        Assert.assertTrue(isEmailWrongFormatErrorAppears);
    }

    @Then("I fill phone number input with {string}")
    public void input_phone_number(String phoneNumber) {
        registrationFirstPage.inputPhoneNumber(phoneNumber);
    }

    @Then("Validation message 'Niepoprawny numer telefonu.' displays under 'Numer kontaktowy' input.")
    public void phone_wrong_format_error_message_appears() {
        boolean isPhoneWrongFormatErrorAppears = registrationFirstPage.isErrorPhoneFormatAppears();
        Assert.assertTrue(isPhoneWrongFormatErrorAppears);
    }

    @Then("I fill imie opiekuna input with {string}")
    public void input_parent_name(String parentName) {
        registrationFirstPage.inputParentName(parentName);
    }

    @Then("I fill year of birth input with {string}")
    public void input_birth_year(String year) {
        registrationFirstPage.inputBirthYear(year);
    }

    @Then("I click Statute Agreement checkbox")
    public void click_statue_agreed_checkbox() {
        registrationFirstPage.checkStatueAgreedCheckbox();
    }

    @Then("I click Advertisement Agreement checkbox")
    public void click_advertisment_agreed_checkbox() {
        registrationFirstPage.checkAdvertisementAgreed();
    }

    @And("Customer moves to second step of registration form")
    public void moves_to_second_registration_page() {
        boolean isMovesToSecondRegistrationPage = registrationSecondPage.isMoveToSecondRegistrationPage();
        Assert.assertTrue(isMovesToSecondRegistrationPage);
    }

    @And("In the navigation first step gets completed and its icon turns into tick icon")
    public void first_step_tick() {
        boolean isFirstStepTicked = registrationSecondPage.isFirstStepTicked();
        Assert.assertTrue(isFirstStepTicked);
    }

    @And("In the navigiation second step is displayed as active")
    public void is_second_step_active() {
        boolean isSecondStepActive = registrationSecondPage.isSecondStepActive();
        Assert.assertTrue(isSecondStepActive);
    }

    @Then("I click on tile with the name of 'PROGRAMOWANIE'")
    public void click_on_programowanie() {
        registrationSecondPage.clickProgramowanie();
    }

    @And("I click on tile called 'Online'")
    public void click_on_online() {
        registrationSecondPage.clickOnline();
    }

    @And("I select button with the name of 'Roczne kursy z programowania'")
    public void click_on_roczne_kursy_z_programowania() {
        registrationSecondPage.clickRoczneKursyZProgramowania();
        registrationThirdPage = new RegistrationThirdPage();
    }

    @Then("I find course {string} and click on Wybierz")
    public void click_on_wybierz_pierwsze_kroki_w_programowaniu(String courseName) {
        registrationThirdPage.clickOnWybierzPierwszeKrokiWProgramowaniu();
        registrationFourthPage = new RegistrationFourthPage();
    }

    @And("From the list of dates I select any that does not contain text 'Zapisy na listę rezerwową'.")
    public void select_course_date() {
        registrationFourthPage.selectCourseDateNotInStandbyList();
    }

    @Then("I fill imie ucznia input with {string}")
    public void fill_in_student_first_name(String name) {
        registrationFourthPage.inputStudentFirstName(name);
    }

    @Then("I fill nazwisko ucznia input with {string}")
    public void fill_in_student_last_name(String name) {
        registrationFourthPage.inputStudentLastName(name);
    }

    @Then("I fill nazwisko opiekuna input with {string}")
    public void fill_in_parent_last_name(String name) {
        registrationFourthPage.inputParentLastName(name);
    }

    @Then("I fill kod pocztowy input with {string}")
    public void fill_in_zip_code(String code) {
        registrationFourthPage.inputZipCode(code);
    }

    @And("I click Zapisz Dziecko button to submit the form")
    public void click_zapisz_dziecko_submit_button(){
        registrationFourthPage.clickSubmitButton();
        registrationFifthPage = new RegistrationFifthPage();

    }

    @Then("I am at Sign Agreement step")
    public void moves_to_fifth_registration_page(){
        boolean isMoveToFifthRegistrationPage = registrationFifthPage.isMoveToFifthRegistrationPage();
        Assert.assertTrue(isMoveToFifthRegistrationPage);
    }

    @And("In the navigation all steps up to agreement are completed")
    public void is_steps_up_to_fifth_completed(){
        boolean isStepsUpToFifthCompleted = registrationFifthPage.isStepsUpToFifthCompleted();
        Assert.assertTrue(isStepsUpToFifthCompleted);
    }
}
