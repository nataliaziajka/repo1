package com.techLeadersProject.automation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.AccordionPage;
import pages.DemoQAPage;

/**
 * Created by Natalia on 2017-01-18.
 */
public class WidgetTest extends BaseTest {
    private final static Logger LOG = Logger.getLogger(AccordionPage.class);

    @Test(enabled = false)
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
    @Test(enabled = false)
    public void pickDateToFreeTextBox(){
        new  DemoQAPage(driver)
                .openDatePickerSection()
                .selectDateWithInlineCalendar();

    }
    @Test(enabled = false)
    public void pickDateFromCalendar(){
        new  DemoQAPage(driver)
                .openDatePickerSection()
                .selectDateFromPopup();

    }
    @Test(enabled = true)
    public void useDefaultSlider(){
        new  DemoQAPage(driver)
                .openSliderSection()
                .useDefaultSliderFunction();


    }

}
