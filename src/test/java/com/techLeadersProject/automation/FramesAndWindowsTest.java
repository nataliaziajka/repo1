package com.techLeadersProject.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DemoQAPage;

import java.util.ArrayList;

/**
 * Created by Natalia on 2017-01-18.
 */
public class FramesAndWindowsTest extends BaseTest{

    @Test(enabled =true)
    public void openNewTab(){
            new DemoQAPage(driver)
                    .openFramesAndWindowsSection()
                    .openNewTab()
                      .assertThatNewTabIsOpen("http://demoqa.com/frames-and-windows/#");
    }

    @Test(enabled = false)
    public void openNewWindow(){
        new DemoQAPage(driver)
                .openFramesAndWindowsSection();

        WebElement element = driver.findElement(By.linkText("New Browser Tab"));
        Actions actionOpenLinkInNewTab = new Actions(driver);
        actionOpenLinkInNewTab.moveToElement(element)
                .keyDown(Keys.SHIFT)
                .click(element)
                .keyUp(Keys.SHIFT)
                .perform();

        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs.get(1)));
        driver.get("http://demoqa.com/frames-and-windows/#");
        driver.close();

        driver.switchTo().window(String.valueOf(tabs.get(0)));
        driver.get("http://demoqa.com/frames-and-windows/");

        driver.close();
    }


}
