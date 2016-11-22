package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Natalia on 2016-11-14.
 */
public abstract class BasePage{
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void waitForWebElementToBeClickable(WebElement webElement) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
