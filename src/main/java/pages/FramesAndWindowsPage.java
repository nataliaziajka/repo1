package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Set;

/**
 * Created by Natalia on 2017-01-23.
 */
public class FramesAndWindowsPage extends BasePage {

    private final static Logger LOG = Logger.getLogger(FramesAndWindowsPage.class);

    public FramesAndWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void assertThatNewTabIsOpen(String expectedNewTabURL) {
        LOG.info("Assert that new tab is open");

        Set<String> set = driver.getWindowHandles();
        assert set.size() == 1;
        String switchedTab = driver.switchTo().window((String) set.toArray()[0]).getCurrentUrl();
        System.out.println(switchedTab);
        Assert.assertEquals(switchedTab, expectedNewTabURL);
    }

    public FramesAndWindowsPage openNewWindow() throws InterruptedException {
        WebElement link = driver.findElement(By.xpath("your link xpath"));
        Actions newwin = new Actions(driver);
        newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(6000);
        return this;
    }
    public FramesAndWindowsPage openNewTab(){
        WebElement link = driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a"));
        Actions newTab = new Actions(driver);
        newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(link).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
        String base = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        set.remove(base);
        assert set.size() == 1;
        WebDriver switchedTab = driver.switchTo().window((String) set.toArray()[0]);
        switchedTab.close();
        driver.switchTo().window(base);


//        Set<String> winSet = webDriver.getWindowHandles();
//        List<String> winList = new ArrayList<String>(winSet);
//        String newTab = winList.get(winList.size() - 1);
//        webDriver.close(); // close the original tab
//        webDriver.switchTo().window(newTab); // switch to new tab

        return this;

    }

}
