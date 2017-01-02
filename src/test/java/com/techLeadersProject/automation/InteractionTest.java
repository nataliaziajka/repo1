package com.techLeadersProject.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.DroppablePage;

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
                .resize()
                    .assertThatSizeOfElementWasChanged();

    }
    @Test(enabled = true)
    public void testSelectable(){
        new DemoQAPage(driver)
            .openSelectableSection()
            .selectMultiElements()
                .assertThatTwoOptionsWereMarked();


        }
    }


