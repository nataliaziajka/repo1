package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Natalia on 2016-12-12.
 */
public class DroppablePage extends BasePage {

    @FindBy(css= "#draggableview>p")
    private WebElement elementToMove;

    @FindBy(css= "#droppableview>p")
    private WebElement moveToElement;

    @FindBy(css="#draggableview>p")
    private WebElement draggableView;

    private final static Logger LOG = Logger.getLogger(DemoQAPage.class);

    public DroppablePage(WebDriver driver) {
        super(driver);
    }
    
    public DroppablePage dragAndDropElement(){
        draggableView.click();
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


