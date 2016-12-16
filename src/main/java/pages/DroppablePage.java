package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * Created by Natalia on 2016-12-12.
 */
public class DroppablePage extends BasePage {

    private final static Logger LOG = Logger.getLogger(DemoQAPage.class);

    public DroppablePage(WebDriver driver) {
        super(driver);
    }
    
    public DroppablePage dragAndDropElement(){
        driver.findElement(By.cssSelector("#draggableview>p")).click();
        WebElement elementToMove = driver.findElement(By.cssSelector("#draggableview>p"));
        WebElement moveToElement = driver.findElement(By.cssSelector("#droppableview>p"));
        Actions dragAndDrop = new Actions(driver);
        Action action = dragAndDrop.dragAndDrop(elementToMove, moveToElement).build();
        action.perform();
        return this;
    }


    public void assertThatDropTextIsDisplayed() {
        LOG.info("Assert that Drop Message is displayed");
        String actualText = driver.findElement(By.cssSelector("#droppableview>p")).getText();
        Assert.assertEquals(actualText, "Dropped!");
    }
}


