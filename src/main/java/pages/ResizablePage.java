package pages;

import org.apache.log4j.Logger;
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
        WebElement elementToResize = this.getDriver().findElement(By.cssSelector("#resizable"));
        try {
            if (elementToResize.isDisplayed()) {
                Actions action = new Actions(driver);
                Action resize = action.clickAndHold(elementToResize).moveByOffset(vectorX, vectorY).release().build();
                resize.perform();
            } else {
                System.out.println("Element was not displayed to drag");
            }
            } catch (StaleElementReferenceException e) {
                System.out.println("Element with " + elementToResize + "is not attached to the page document " + e.getStackTrace());
            } catch (NoSuchElementException e) {
                System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
            } catch (Exception e) {
                System.out.println("Unable to resize" + elementToResize + " - " + e.getStackTrace());
        }
        return this;
    }

    public void assertThatSizeOfElementWasChanged(int vectorX, int vectorY) {
        LOG.info("Assert that size of element was changed");

        WebElement Image = driver.findElement(By.cssSelector("#resizable"));

        int imageWidth1 = Image.getSize().getWidth();
        int imageHeight1 = Image.getSize().getHeight();

        driver.manage().window().setSize(new Dimension(vectorX, vectorY));
        WebElement ResizeImage;
        ResizeImage = driver.findElement(By.cssSelector("#resizable"));
        int imageWidth2 = ResizeImage.getSize().getWidth();
        int imageHeight2 = Image.getSize().getHeight();

        if (imageWidth1 == imageWidth2)
            System.out.println("Wight is the same");
        else
            System.out.println("Wight is not the same");

        if (imageHeight1 == imageHeight2)
            System.out.println("Height is the same");
        else
            System.out.println("Heightt is not the same");

    }

}

