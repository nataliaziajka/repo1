package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
        openDemoQApage();
    }

    public DemoQAPage openDemoQApage(){
        LOG.info("Open DemoQA Page");
        driver.get("http://www.demoqa.com");
        return this;
    }

    public DemoQAPage assertThatDemoQALogoIsDisplayed() {
        LOG.info("Assert DemoQA Page Is Open");
        Assert.assertTrue(logo.isDisplayed());
        return this;
    }

    public RegistrationPage clickToRegistrationLink(){
        LOG.info("Click registration link");
        waitForWebElementToBeClickable(registrationLink);
        registrationLink.click();
        return PageFactory.initElements(driver, RegistrationPage.class);
    }

//    public DemoQAPage openDraggableSection(){
//        LOG.info("Open Draggable section");
//        driver.get("http://demoqa.com/draggable/");
//        return this;
//    }

    public DroppablePage openDroppableSection(){
        LOG.info("Open Droppable section");
        driver.get("http://demoqa.com/droppable/");
        return PageFactory.initElements(driver, DroppablePage.class);
    }

    public ResizablePage openResizableSection(){
        LOG.info("Open Resizable section");
        driver.get("http://demoqa.com/resizable/");
        return PageFactory.initElements(driver, ResizablePage.class);
    }

    public SelectablePage openSelectableSection(){
        LOG.info("Open Selectable section");
        driver.get("http://demoqa.com/selectable/");
        return PageFactory.initElements(driver, SelectablePage.class);
    }
 }
