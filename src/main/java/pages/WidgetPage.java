package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Natalia on 2017-03-02.
 */
public class WidgetPage extends BasePage {
    private final static Logger LOG = Logger.getLogger(WidgetPage.class);

    public WidgetPage(WebDriver driver) {
        super(driver);
    }

    public WidgetPage useDefaultAccordion() {
        WebElement expanded = driver.findElement(By.cssSelector("#ui-id-1"));
        expanded.click();
        List<WebElement> allinks= driver.findElements(By.cssSelector(".inside_contain"));
        for(WebElement w:allinks){
            new Actions(driver).click(w).build().perform();}
        return this;
    }
    public WidgetPage assertThatArrowWasChanged(){
        LOG.info("Assert that Arrow was changed after click the header");
        WebElement element = driver.findElement(By.xpath(".//*[@id='ui-id-4']/span"));
        element.click();
        Assert.assertTrue(element.getAttribute("class").contains("ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"));
        return this;

    }
    public WidgetPage assertThatSectionOpened(){
        LOG.info("Assert that section is opened");
        WebElement element = driver.findElement(By.xpath(".//*[@id='ui-id-5']"));
        element.click();
        Assert.assertTrue(element.getAttribute("style").contains("display: block"));
        return this;

    }
}
