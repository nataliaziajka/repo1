package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Natalia on 2016-12-15.
 */
public class ResizablePage extends BasePage {

    @FindBy(css="#resizable")
    private WebElement resizeableElement;

    @FindBy(css="#resizable > div:nth-of-type(3)")
    private  WebElement anchorForResize;

    private final static Logger LOG = Logger.getLogger(ResizablePage.class);
    private final static int OFFSET = 50;
    private int startWidthElement;
    private int startHeightElement;
    private int anchorWidth;
    private int anchorHeight;

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public void assertThatSizeOfElementWasChanged() {
        WebElement elementAfterResize = getDriver().findElement(By.cssSelector("#resizable"));
        Dimension elementSize = elementAfterResize.getSize();
        System.out.println("End width: " + elementSize.getWidth());
        System.out.println("End height: " + elementSize.getHeight());
        LOG.info("Assert that Wight is the same");
        Assert.assertEquals("Width is wrong after resize", (startWidthElement + OFFSET - anchorWidth - 1), elementSize.getWidth());
        LOG.info("Assert that Height is the same");
        Assert.assertEquals("Height is wrong after resize",(startHeightElement + OFFSET - anchorHeight - 1), elementSize.getHeight());
    }

    public ResizablePage resizeElement() {
        startWidthElement = resizeableElement.getSize().getWidth();
        startHeightElement = resizeableElement.getSize().getHeight();
        System.out.println("Start width: " + startWidthElement);
        System.out.println("Start height: " + startHeightElement);
        resize(OFFSET, OFFSET);
        return this;
    }

    private void resize(int xOffset, int yOffset) {
        Actions action = new Actions(driver);
        anchorWidth = anchorForResize.getSize().getWidth();
        anchorHeight = anchorForResize.getSize().getHeight();
        action.clickAndHold(anchorForResize).moveByOffset(xOffset, yOffset).release().build().perform();
    }
}


