package com.techLeadersProject.automation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GooglePage;

public class FirstDemoQATest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\Instalki\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void openGooglePage(){
        new GooglePage(driver).openGooglePage()

        .clickToSearchField()
        .sendLinkToOpen()
        .clickEnterToConfirmTheChoice()
        .clickToDemoQALink()
                .assertThatDemoQALogoIsDisplayed();
    }

}




