package com.techLeadersProject.automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.DroppablePage;
import pages.ResizablePage;

/**
 * Created by Natalia on 2016-12-12.
 */
public class InteractionTest extends BaseTest {
    private final static Logger LOG = Logger.getLogger(DroppablePage.class);

    public WebDriver getDriver() {
        return driver;
    }


    @Test
    public void testDragAndDrop()throws InterruptedException {
        //driver = new FirefoxDriver();  -->on the internet was information that this functionality works only on FF
        new DemoQAPage(driver)
                .openDroppableSection()
                .dragAndDropElement()
                    .assertThatDropTextIsDisplayed();
        }
    @Test
    public void testResizable() {
        //driver = new FirefoxDriver();  -->on the internet was information that this functionality works only on FF
        new DemoQAPage(driver)
                .openResizableSection()
                .changeSizeOfElement()
                    .assertThatSizeOfElementWasChanged();






    }


    }

