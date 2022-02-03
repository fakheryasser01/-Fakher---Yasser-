package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private By facebookLogo = By.cssSelector("img[class='fb_logo _8ilh img']");
    private By facebookSlogan = By.className("_8eso");
    private By emailField = By.id("email");
    private By passwordFiled = By.id("pass");
    private By loginBtn = By.name("login");
    private By forgottenPasswordBtn = By.cssSelector("div[class='_6ltj'] >a");
    private By createNewAccountBtn = By.cssSelector("a[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']");
    private By stopUsingIcon = By.cssSelector("img[class='_7ku img']");
    private By incorrectEmailMessage = By.className("_9kq2");


    public Boolean isIncorrectEmailMessageDisplayed() {
        waitUntilAppearanceOf(incorrectEmailMessage);
        return driver.findElement(incorrectEmailMessage).isDisplayed();
    }

    public Boolean isStopUsingFacebookIconDisplayed() {
        waitUntilAppearanceOf(stopUsingIcon);
        return driver.findElement(stopUsingIcon).isDisplayed();
    }

    private LoginPage setEmailField(String email) {
        enterData(emailField, email);
        return this;
    }

    private LoginPage setPasswordFiled(String password) {
        enterData(passwordFiled, password);
        return this;
    }

    public void clickOnLoginBtn() {
        clickOn(loginBtn);
    }


    public void userLogin(String email, String password) {

        setEmailField(email);
        setPasswordFiled(password);
    }

    public SignUpPage clickOnSignUpBtn() {
        clickOn(createNewAccountBtn);
        return new SignUpPage(driver);
    }


    public Boolean isLoginBtnDisplayed() {
        return driver.findElement(loginBtn).isDisplayed();
    }
}
