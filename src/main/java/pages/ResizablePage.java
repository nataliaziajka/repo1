package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Natalia on 2016-12-15.
 */
public class ResizablePage extends BasePage {

    private final static Logger LOG = Logger.getLogger(ResizablePage.class);

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public ResizablePage resize() {
        WebElement resizeable = this.getDriver().findElement(By.cssSelector("#resizable"));
        Actions action = new Actions(driver);
        Action resize = action.clickAndHold(resizeable).moveByOffset(250, 250).release().build();
        resize.perform();
        return this;

    }

    public void assertThatSizeOfElementWasChanged() {
        LOG.info("Assert that size of element was changed");

        WebElement Image = driver.findElement(By.cssSelector("#resizable"));

        int imageWidth1 = Image.getSize().getWidth();
        int imageHeight1 = Image.getSize().getHeight();

        driver.manage().window().setSize(new Dimension(400,400));
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

