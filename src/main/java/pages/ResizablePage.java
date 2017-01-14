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

    public ResizablePage resize(int vectorX, int vectorY) {
        WebElement elementToResize = getDriver().findElement(By.cssSelector("#resizable"));
            if (elementToResize.isDisplayed()) {
                Actions action = new Actions(driver);
                Action resize = action.clickAndHold(elementToResize).moveByOffset(vectorX, vectorY).release().build();
                resize.perform();
        }
        return this;
    }

    public void assertThatSizeOfElementWasChanged(int vectorX, int vectorY) {
        WebElement Image = driver.findElement(By.cssSelector("#resizable"));

        int imageWidth1 = Image.getSize().getWidth();
        int imageHeight1 = Image.getSize().getHeight();

        driver.manage().window().setSize(new Dimension(vectorX, vectorY));
        WebElement ResizeImage;
        ResizeImage = driver.findElement(By.cssSelector("#resizable"));

        int imageWidth2 = ResizeImage.getSize().getWidth();
        int imageHeight2 = Image.getSize().getHeight();

            LOG.info("Assert that Wight is the same");
            Assert.assertEquals(imageWidth2, 300);
            LOG.info("Assert that Height is the same");
            Assert.assertEquals(imageHeight2,300);

    }

}

