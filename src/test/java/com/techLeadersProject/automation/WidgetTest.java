package com.techLeadersProject.automation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.WidgetPage;

/**
 * Created by Natalia on 2017-01-18.
 */
public class WidgetTest extends BaseTest {
    private final static Logger LOG = Logger.getLogger(WidgetPage.class);

    @Test
    public void defaultAccordionDisplay() {
        new DemoQAPage(driver)
                .openAccordionSection()
                .useDefaultAccordion()
                .assertThatArrowWasChanged()
                .assertThatSectionOpened();
    }}
