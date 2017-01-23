package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

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
            Assert.assertEquals(300, elementSize.getWidth());
            LOG.info("Assert that Height is the same");
            Assert.assertEquals(300, elementSize.getHeight());
    }

    public ResizablePage resize(int vectorX, int vectorY) {
        WebElement elementToResize = getDriver().findElement(By.xpath(".//*[@id='resizable']/div[3]"));
            Dimension sizeBefore = elementToResize.getSize();
            System.out.println(sizeBefore.getWidth());
            System.out.println(sizeBefore.getHeight());

        if (elementToResize.isDisplayed()) {
            Actions action = new Actions(driver);
            action.moveToElement(elementToResize);
            action.clickAndHold();
            action.moveByOffset(vectorX, vectorY);
            action.release().perform();
        }
        return this;
    }
}

