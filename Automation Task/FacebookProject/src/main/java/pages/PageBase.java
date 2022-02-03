package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PageBase {
    static WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }




    public static void waitUntilAppearanceOf(By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }

    public static void clickOn(By element) {
        waitUntilAppearanceOf(element);
        driver.findElement(element).click();
    }

    public static void enterData(By element, String value) {
        waitUntilAppearanceOf(element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    public static String getElementText(By element) {
        waitUntilAppearanceOf(element);
        System.out.println("The element Test : " + driver.findElement(element).getText());
        return driver.findElement(element).getText();
    }

}
