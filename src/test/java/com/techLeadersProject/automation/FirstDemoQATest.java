package com.techLeadersProject.automation;

import org.junit.Test;
import pages.GooglePage;

public class FirstDemoQATest extends BaseTest {

    @Test
    public void openGooglePage() {
        new GooglePage(driver)
                .openGooglePage()
                .enterSearchPhrase("demoqa.com")
                .clickEnterToConfirmTheChoice()
                .clickToDemoQALink()
                .assertThatDemoQALogoIsDisplayed();
        }
    }