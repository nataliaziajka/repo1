package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Natalia on 2016-11-16.
 */
public class DemoQAPage {

    private final static Logger LOG = Logger.getLogger(DemoQAPage.class);

    @FindBy(xpath="//img[contains(@src,'http://demoqa.com/wp-content/uploads/2014/08/Tools-QA-213.png')]")
    private WebElement logo;

    public DemoQAPage assertThatDemoQALogoIsDisplayed() {
        LOG.info("Assert DemoQA Page Is Open");
        Assert.assertTrue(logo.isDisplayed());
        return this;
    }
 }
