package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Natalia on 2017-01-23.
 */
public class FramesAndWindowsPage extends BasePage {

    @FindBy(xpath = ".//*[@id='tabs-1']/div/p/a")
    private WebElement linkToOpenNewTab;

    @FindBy(xpath = ".//*[@id='tabs-2']/div/p/a")
    private WebElement linkToOpenNewWindow;

    @FindBy(xpath= ".//*[@id='ui-id-2']")
    private WebElement windowMenuLink;

    @FindBy(xpath=".//*[@id='tabs-1']/div/p/a")
    private  WebElement link;

    private final static Logger LOG = Logger.getLogger(FramesAndWindowsPage.class);

    public FramesAndWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void assertThatNewTabIsOpen(String expectedNewTabURL) {
        LOG.info("Assert that new tab is open");
        String oldTab = driver.getWindowHandle();
        linkToOpenNewTab.click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        String switchedTab = driver.switchTo().window(newTab.get(0)).getCurrentUrl();

        Assert.assertEquals(switchedTab, expectedNewTabURL);
    }

    public void assertThatNewSeparateWindowIsOpen(String expectedTitlePage) {
        LOG.info("Assert that new separate window is open");
        String oldWin = driver.getWindowHandle();
        linkToOpenNewWindow.click();
        ArrayList<String> newWin = new ArrayList<String>(driver.getWindowHandles());
        newWin.remove(oldWin);
        driver.switchTo().window(newWin.get(0)).getCurrentUrl();
        String textOnpage = driver.findElement(By.cssSelector(".entry-title")).getText();

        Assert.assertEquals(textOnpage, expectedTitlePage);
        
    }

    public FramesAndWindowsPage openNewWindow() {
        windowMenuLink.click();
        Actions newWin = new Actions(driver);
        newWin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
        return this;
    }
    public FramesAndWindowsPage openNewTab(){
        link.click();
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
