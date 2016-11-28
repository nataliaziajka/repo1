package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Natalia on 2016-11-14.
 */
public class GooglePage extends BasePage {

    private final static Logger LOG = Logger.getLogger(GooglePage.class);

    @FindBy(xpath=".//a[@href='http://demoqa.com/']")
    WebElement linkToDemoQA;

    @FindBy(id = "lst-ib")
    WebElement searchField;

    @FindBy(css = "#sblsbb > .lsb")
    WebElement searchButton;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public GooglePage openGooglePage(){
        LOG.info("Open google page");
        driver.get("http://google.pl");
        return this;
    }

    public DemoQAPage clickToDemoQALink(){
        LOG.info("Click demoQA link");
        waitForWebElementToBeClickable(linkToDemoQA);
        linkToDemoQA.click();
        return PageFactory.initElements(driver, DemoQAPage.class);
    }

    public GooglePage enterSearchPhrase(String searchText){
        LOG.info("Send link to open");
        waitForWebElementToBeClickable(searchField);
        searchField.sendKeys(searchText);
        return this;
    }

    public GooglePage clickEnterToConfirmTheChoice(){
        LOG.info("Press Search button");
        searchButton.click();
        return this;
    }
}



