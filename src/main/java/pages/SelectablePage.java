package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Natalia on 2016-12-30.
 */
public class SelectablePage extends BasePage{

    private final static Logger LOG = Logger.getLogger(RegistrationPage.class);
    private final static String LIST_OF_ELEMENTS = ".//*[@id='tabs-1']/div/ol/li";
    private final static String EXP_CLASS_TEXT = "ui-widget-content ui-corner-left ui-selectee ui-selected";

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    public SelectablePage assertThatTwoOptionsWereMarked() {
        LOG.info("Assert that two options were marked");
        //Assert.assertEquals(actualClassText.compareTo(EXP_CLASS_TEXT));
        return this;
    }

    public SelectablePage selectMultiElements() {
        LOG.info("Select two first option");
        List<WebElement> listItems = driver.findElements(By.xpath(LIST_OF_ELEMENTS));
        Actions builder = new Actions(driver);
        builder.clickAndHold(listItems.get(1)).clickAndHold(listItems.get(2)).click();
        Action selectMultiple = builder.build();
        selectMultiple.perform();

        // Comment: -->This is solution for the option elements displayed in this select tag

//        Select boxElements = new Select(driver.findElement(By.xpath(".//*[@id='tabs-1']/div")));
//        boxElements.selectByIndex(0);
//        boxElements.deselectByIndex(0);
//
//        boxElements.selectByVisibleText("Item 1");
//        boxElements.deselectByVisibleText("Item 2");
//
//        List<WebElement> boxSize = boxElements.getOptions();
//        int iListSize = boxSize.size();
//            for (int i = 0; i < iListSize; i++) {
//
//                String sValue = boxElements.getOptions().get(i).getText();
//                System.out.println(sValue);
//                boxElements.selectByIndex(i);
//                boxElements.deselectAll();
//                driver.close();
//            }

        return this;

    }

}
