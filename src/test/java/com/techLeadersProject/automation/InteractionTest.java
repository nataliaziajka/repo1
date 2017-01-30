package com.techLeadersProject.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.DroppablePage;

import java.util.Arrays;

/**
 * Created by Natalia on 2016-12-12.
 */
public class InteractionTest extends BaseTest {
    private final static Logger LOG = Logger.getLogger(DroppablePage.class);

    public WebDriver getDriver() {
        return driver;
    }


    @Test(enabled = false)
    public void testDragAndDrop()throws InterruptedException {
        //Comment: driver = new FirefoxDriver();  -->on the internet was information that this functionality works only on FF
        new DemoQAPage(driver)
                .openDroppableSection()
                .dragAndDropElement()
                    .assertThatDropTextIsDisplayed();
        }
    @Test(enabled = false)
    public void testResizable() {
        //Comment: driver = new FirefoxDriver();  -->on the internet was information that this functionality works only on FF
        new DemoQAPage(driver)
                .openResizableSection()
                .resize(150, 150)
                    .assertThatSizeOfElementWasChanged();

    }
    @Test(enabled = false)
    public void testSelectable(){
        new DemoQAPage(driver)
            .openSelectableSection()
               .selectMultiElements(Arrays.asList("Item 7", "Item 6", "Item 4", "Item 1"))
                       .assertListSelectedItems(Arrays.asList("Item 7", "Item 6", "Item 4", "Item 1"));
        }
    }


