package com.techLeadersProject.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Natalia on 2016-11-16.
 */
public class DemoQAPage extends BasePage{

    private final static Logger LOG = Logger.getLogger(DemoQAPage.class);

    @FindBy(xpath="//img[contains(@src,'http://demoqa.com/wp-content/uploads/2014/08/Tools-QA-213.png')]")
    private WebElement logo;

    @FindBy(css="a[href*='registration']")
    private WebElement registrationLink;

    public DemoQAPage(WebDriver driver) {
        super(driver);
        //skoro inicjalizujesz stronke to fajnie żeby ona od razu była otwarta.
        //moze byc osobna metoda
        //ale rownie dobrze jak nie lepiej gdyby te dwie linie z openDemoQApage były od razu tu
//        LOG.info("Open DemoQA Page");
//        driver.get("http://www.demoqa.com");

        //i wtedy tej linii ani metody nie ma
        openDemoQApage();
    }

    public DemoQAPage openDemoQApage(){
        LOG.info("Open DemoQA Page");
        driver.get("http://www.demoqa.com");
        return this;
    }

    public DemoQAPage assertThatDemoQALogoIsDisplayed() {
        LOG.info("Assert DemoQA Page Is Open");
        Assert.assertTrue(logo.isDisplayed());
        return this;
    }

    public RegistrationPage clickToRegistrationLink(){
        LOG.info("Click registration link");
        waitForWebElementToBeClickable(registrationLink);
        registrationLink.click();
        return PageFactory.initElements(driver, RegistrationPage.class);
    }
 }