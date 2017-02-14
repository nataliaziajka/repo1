package com.techLeadersProject.automation;

import org.testng.annotations.Test;
import pages.DemoQAPage;

/**
 * Created by Natalia on 2017-01-18.
 */
public class FramesAndWindowsTest extends BaseTest {

    @Test(enabled = true)
    public void openNewTab() {
        new DemoQAPage(driver)
                .openFramesAndWindowsSection()
                .openNewTab()
                .assertThatNewTabIsOpen("http://demoqa.com/frames-and-windows/#");
    }

    @Test(enabled = true)
    public void openNewWindow() {
        new DemoQAPage(driver)
                .openFramesAndWindowsSection()
                .openNewWindow()
                .assertThatNewSeparateWindowIsOpen("Oops! That page can’t be found.");
    }
}
