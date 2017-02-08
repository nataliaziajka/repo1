package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
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
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        String switchedTab = driver.switchTo().window(newTab.get(0)).getCurrentUrl();

        Assert.assertEquals(switchedTab, expectedNewTabURL);
    }

    public void assertThatNewSeparateWindowIsOpen(String expectedTitlePage) {
        LOG.info("Assert that new separate window is open");
        String oldWin = driver.getWindowHandle();
        driver.findElement(By.xpath(".//*[@id='tabs-2']/div/p/a")).click();
        ArrayList<String> newWin = new ArrayList<String>(driver.getWindowHandles());
        newWin.remove(oldWin);
        driver.switchTo().window(newWin.get(0)).getCurrentUrl();
        String textOnpage = driver.findElement(By.cssSelector(".entry-title")).getText();

        Assert.assertEquals(textOnpage, expectedTitlePage);
        
    }



    public FramesAndWindowsPage openNewWindow() {
        WebElement windowMenuLink = driver.findElement(By.xpath(".//*[@id='ui-id-2']"));
        windowMenuLink.click();
        WebElement link = driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a"));
        Actions newWin = new Actions(driver);
        newWin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
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

        return this;

    }

}
