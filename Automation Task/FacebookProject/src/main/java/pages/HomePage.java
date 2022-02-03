package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By facebookLogoIcon = By.cssSelector("svg[class='a8c37x1j ms05siws hwsy1cff b7h9ocf4']");
    private By accountIcon = By.cssSelector("div[class='j83agx80 l9j0dhe7']");
    private By logOutBtn = By.cssSelector("div[data-nocookies='true']");


    public Boolean isFacebookIconDisplayed() {
        waitUntilAppearanceOf(facebookLogoIcon);
        return driver.findElement(facebookLogoIcon).isDisplayed();
    }

    public HomePage clickOnAccountIcon() {
        clickOn(accountIcon);
        return this;
    }

    public void clickOnLogOutBtn() {
        clickOn(logOutBtn);
    }
}
