package pages;

import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Natalia on 2017-03-02.
 */
public class AccordionPage extends BasePage {

    @FindBy(css = "#ui-id-1")
    private WebElement expandedBox;

    @FindBy(css = ".inside_contain")
    private List<WebElement> allLinks;

    @FindBy(xpath = ".//*[@id='ui-id-5']")
    private WebElement element;

    @FindBy(xpath = ".//*[@id='ui-id-4']/span")
    private WebElement arrowElement;

    private final static Logger LOG = Logger.getLogger(AccordionPage.class);

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public AccordionPage useDefaultAccordionFunction() {
        expandedBox.click();
        for(WebElement w:allLinks){
            new Actions(driver).click(w).build().perform();}
        return this;
    }
    public AccordionPage assertThatArrowWasChanged(){
        LOG.info("Assert that Arrow was changed after click the header");
        arrowElement.click();
        Assert.assertTrue(arrowElement.getAttribute("class").contains("ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"));
        return this;

    }
    public AccordionPage assertThatSectionOpened(){
        LOG.info("Assert that section is opened");
        element.click();
        Assert.assertTrue(element.getAttribute("style").contains("display: block"));
        return this;

    }
}
