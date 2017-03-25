package com.techLeadersProject.automation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.AccordionPage;

/**
 * Created by Natalia on 2017-01-18.
 */
public class WidgetTest extends BaseTest {
    private final static Logger LOG = Logger.getLogger(AccordionPage.class);

    @Test(enabled = true)
    public void defaultAccordionDisplay() {
        new DemoQAPage(driver)
                .openAccordionSection()
                .useDefaultAccordionFunction()
                .assertThatArrowWasChanged()
                .assertThatSectionOpened();
    }

    @Test(enabled = false)
    public void defaultAutocompleteDisplay() throws InterruptedException {
        new DemoQAPage(driver)
                .openAutocompleteSection()
                .useDefaultAutocompleteFunction()
                .assertThatElementIsSelectedFromSuggestionsList();

    }

}
