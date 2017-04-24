package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Natalia on 2017-04-02.
 */
public class SliderPage extends BasePage {

    private final static Logger LOG = Logger.getLogger(DatePickerPage.class);

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public SliderPage useDefaultSliderFunction() {
        WebElement draggable = driver.findElement(By.cssSelector("#slider-range-max"));
        new Actions(driver).dragAndDropBy(draggable, 120, 0).build().perform();
        return this;
    }
}
