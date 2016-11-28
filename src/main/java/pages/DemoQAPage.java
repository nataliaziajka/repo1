package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Natalia on 2016-11-16.
 */
public class DemoQAPage extends BasePage{

    private final static Logger LOG = Logger.getLogger(DemoQAPage.class);

    @FindBy(xpath="//img[contains(@src,'http://demoqa.com/wp-content/uploads/2014/08/Tools-QA-213.png')]")
    private WebElement logo;

    @FindBy(css="a[href*='registration']")
    private WebElement registrationLink;

    public DemoQAPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.demoqa.com");
    }

    public DemoQAPage assertThatDemoQALogoIsDisplayed() {
        LOG.info("Assert DemoQA Page Is Open");
        Assert.assertTrue(logo.isDisplayed());
        return this;
    }

    public DemoQAPage clickToRegistrationLink(){
        LOG.info("Click registration link");
        waitForWebElementToBeClickable(registrationLink);
        registrationLink.click();
//        return PageFactory.initElements(driver, RegistrationPage.class);
        return this;
    }


 }
