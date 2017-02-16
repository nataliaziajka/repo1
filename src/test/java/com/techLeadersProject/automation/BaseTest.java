package com.techLeadersProject.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Natalia on 2016-11-28.
 */
public abstract class BaseTest {

    static WebDriver driver;
    public String userName;
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int length = 10;
    private int randomNumber;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //(new DOMConfigurator()).doConfigure(getClass().getResourceAsStream("\\log4j.properties"), LogManager.getLoggerRepository());
    }

    public String generateString() {
        String uuid = UUID.randomUUID().toString().substring(0, 10);
        char[] randText = new char[length];
        for (int i = 0; i < length; i++) {
            randText[i] = characters.charAt((int) (Math.random() * length));
        }
        return new String(randText);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
