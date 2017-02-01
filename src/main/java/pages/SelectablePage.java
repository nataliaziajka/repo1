package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Natalia on 2016-12-30.
 */
public class SelectablePage extends BasePage {

    @FindBy(xpath = ".//*[@id='tabs-1']/div/ol/li")
    private WebElement listOfElements;

    @FindBy(css = "ol#selectable li.ui-selected")
    private List<WebElement> listSelectedItems;

    private List<WebElement> listSelectedGridItems;

    private final static Logger LOG = Logger.getLogger(RegistrationPage.class);
    final static String LIST_OF_ELEMENTS = ".//*[@id='tabs-1']/div/ol/li[text()='%s']";

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    public SelectablePage assertListSelectedItems(List<String> expectedSelectedItems) {
        LOG.info("Check selected list items");
        List<String> actualSelectedItems = new ArrayList<String>();
        for (WebElement listItem : listSelectedItems) {
            actualSelectedItems.add(listItem.getText());
        }
        Collections.sort(actualSelectedItems);
        Collections.sort(expectedSelectedItems);

        Assert.assertEquals(actualSelectedItems, expectedSelectedItems);
        return this;
    }

    public SelectablePage assertGridSelectedItems(List<String> expectedSelectedGridItems) {
        LOG.info("Check grid selected items");
        List<String> actualSelectedGrid = new ArrayList<String>();
        for (WebElement listItem : listSelectedGridItems) {
            actualSelectedGrid.add(listItem.getText());
        }
        Assert.assertEquals(actualSelectedGrid, expectedSelectedGridItems);
        return this;
    }

        public SelectablePage selectMultiElements(List<String> itemsToSelect) {
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL);
            for (String s : itemsToSelect) {
                actions.click(driver.findElement(By.xpath(String.format(LIST_OF_ELEMENTS, s))));
                actions.perform();
            }
            return this;
        }
}

