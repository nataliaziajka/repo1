package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Natalia on 2016-11-14.
 */
public class GooglePage extends BasePage {


    @FindBy(xpath=".//a[@href='http://demoqa.com/']")
    WebElement linkToDemoQA;

    WebElement searchField = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("sb_ifc0")));

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public GooglePage openGooglePage(){
        driver.get("http://google.pl");
        return this;
    }

    public DemoQAPage clickToDemoQALink(){
        linkToDemoQA.click();
        return PageFactory.initElements(driver, DemoQAPage.class);
    }

    public GooglePage sendLinkToOpen(){
        searchField.sendKeys("demoqa.com");
        return this;
    }

    public GooglePage clickToSearchField(){
        searchField.click();
        return this;
    }

    public GooglePage clickEnterToConfirmTheChoice(){
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
}



