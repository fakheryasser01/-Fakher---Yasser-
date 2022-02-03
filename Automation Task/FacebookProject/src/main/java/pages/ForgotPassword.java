package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword extends PageBase {
    public ForgotPassword(WebDriver driver) {
        super(driver);
    }

    private By incorrectEmailAndPasswordMessage = By.cssSelector("div[class='fsl fwb fcb']");

    public Boolean isIncorrectPasswordMessageDisplayed() {
        waitUntilAppearanceOf(incorrectEmailAndPasswordMessage);
        return driver.findElement(incorrectEmailAndPasswordMessage).isDisplayed();
    }

}
