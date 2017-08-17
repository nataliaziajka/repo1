package com.techLeadersProject.automation;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.DemoQAPage;
import pages.TooltipPage;

/**
 * Created by Natalia on 2017-05-07.
 */
public class TooltipTest extends BaseTest {
    private final static Logger LOG = Logger.getLogger(TooltipPage.class);


    @Test(enabled = true)
    public void defaultTooltipDisplay(){
        new DemoQAPage(driver)
                .openTooltipSetion()
                .selectElementWithTooltip()
                .assertThatTooltipTextIsDisplayed();




    }


}