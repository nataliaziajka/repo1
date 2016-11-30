package com.techLeadersProject.automation;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by Natalia on 2016-11-28.
 */
public class BaseTest {

    static WebDriver driver;

    public BaseTest() {

    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Instalki\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PropertyConfigurator.configure("log4j.properties");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
