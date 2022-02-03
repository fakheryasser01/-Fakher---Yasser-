package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends PageBase {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private By closeSignUpIcon = By.className("_8idr img");
    private By firstnameField = By.name("firstname");
    private By lastnameField = By.name("lastname");
    private By emailField = By.name("reg_email__");
    private By emailConfirmationField = By.name("reg_email_confirmation__");
    private By newPasswordField = By.id("password_step_input");
    private By dayDropdown = By.id("day");
    private By monthDropdown = By.id("month");
    private By yearDropdown = By.id("year");
    private By genderBtn = By.name("sex");
    private By signUpBtn = By.name("websubmit");
    private By userNameErrorMessage = By.id("reg_error_inner");
    private By birthDateErrorMessage = By.cssSelector("div[data-ownerid='day'] > div >div > div[class='_5633 _5634 _53ij']");
    private By errorMessages = By.cssSelector("div[class='_5633 _5634 _53ij']");

    public Boolean isOnOfErrorMessagesListDisplayed(String message) {
        List<WebElement> errorMessagesList = driver.findElements(errorMessages);
        for (WebElement e : errorMessagesList) {

            if (e.getText().contains(message)) {
                return driver.findElement(errorMessages).isDisplayed();
            }
        }
        return false;
    }

    public String getBirthDateErrorMessage() {
        return getElementText(birthDateErrorMessage);
    }


    public Boolean isUserNameErrorMessageDisplayed() {
        waitUntilAppearanceOf(userNameErrorMessage);
        return driver.findElement(userNameErrorMessage).isDisplayed();
    }

    public String getErrorMessage() {
        return getElementText(userNameErrorMessage);
    }

    public SignUpPage setFirstName(String firstName) {
        enterData(firstnameField, firstName);
        return this;
    }

    public SignUpPage setLastName(String lastName) {
        enterData(lastnameField, lastName);
        return this;
    }

    public SignUpPage setEmail(String email) {
        enterData(emailField, email);
        return this;
    }

    public SignUpPage setEmailConfirmation(String emailConfirmation) {
        enterData(emailConfirmationField, emailConfirmation);
        return this;
    }


    public SignUpPage setNewPassword(String newPassword) {
        enterData(newPasswordField, newPassword);
        return this;
    }


    public SignUpPage selectDayFromDropDown(String option) {
        waitUntilAppearanceOf(dayDropdown);
        Select dropDownElement = new Select(driver.findElement(dayDropdown));
        dropDownElement.selectByValue(option);
        return this;

    }

    public SignUpPage selectMonthFromDropDown(String option) {
        waitUntilAppearanceOf(monthDropdown);
        Select dropDownElement = new Select(driver.findElement(monthDropdown));
        dropDownElement.selectByVisibleText(option);
        return this;

    }

    public SignUpPage selectYearFromDropDown(String option) {
        waitUntilAppearanceOf(yearDropdown);
        Select dropDownElement = new Select(driver.findElement(yearDropdown));
        dropDownElement.selectByValue(option);
        return this;
    }

    public SignUpPage selectGender(String gender) {
        waitUntilAppearanceOf(genderBtn);
        if (gender.contains("Female")) {
            driver.findElements(genderBtn).get(0).click();
        } else if (gender.contains("Male")) {
            driver.findElements(genderBtn).get(1).click();
        } else if (gender.contains("Custom")) {
            driver.findElements(genderBtn).get(2).click();
        } else {

        }

        return this;
    }

    public void clickOnSignUpBtn() {
        clickOn(signUpBtn);
    }


    public SignUpPage fillSignUpUserData(String firstName, String lastName, String email, String emailConfirmation, String password, String dayOfBirth,
                                         String monthOfBirth, String yearOfBirth, String gender) {
        setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setEmailConfirmation(emailConfirmation)
                .setNewPassword(password)
                .selectDayFromDropDown(dayOfBirth)
                .selectMonthFromDropDown(monthOfBirth)
                .selectYearFromDropDown(yearOfBirth)
                .selectGender(gender);

        return this;
    }

    public SignUpPage fillSignUpUserDataWithOutDateOfBirth(String firstName, String lastName, String email, String emailConfirmation, String password
            , String gender) {
        setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setEmailConfirmation(emailConfirmation)
                .setNewPassword(password)

                .selectGender(gender);

        return this;
    }

}
