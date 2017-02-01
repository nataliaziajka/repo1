package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Natalia on 2016-12-15.
 */
public class ResizablePage extends BasePage {

    private final static Logger LOG = Logger.getLogger(ResizablePage.class);

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public void assertThatSizeOfElementWasChanged() {
        WebElement elementAfterResize = getDriver().findElement(By.cssSelector("#resizable"));
        Dimension elementSize = elementAfterResize.getSize();
        System.out.println(elementSize.getWidth());
        System.out.println(elementSize.getHeight());

        LOG.info("Assert that Wight is the same");
        Assert.assertEquals(183, elementSize.getWidth());
        LOG.info("Assert that Height is the same");
        Assert.assertEquals(183, elementSize.getHeight());
    }


public ResizablePage resizeElement() {

    WebElement resizeableElement = driver.findElement(By.cssSelector("#resizable > div:nth-of-type(3)"));
    resize(resizeableElement, 50,50);

    return this;
}

    public void resize(WebElement elementToResize, int xOffset, int yOffset) {

            Actions action = new Actions(driver);
            action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
    }









}


