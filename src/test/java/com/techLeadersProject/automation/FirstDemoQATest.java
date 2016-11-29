package com.techLeadersProject.automation;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;

public class FirstDemoQATest extends BaseTest {

    public FirstDemoQATest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void openGooglePage() {
        new GooglePage(driver).openGooglePage()
                .enterSearchPhrase("demoqa.com")
                .clickEnterToConfirmTheChoice()
                .clickToDemoQALink()
                .assertThatDemoQALogoIsDisplayed();
        }
    }





