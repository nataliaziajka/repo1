package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Natalia on 2017-05-07.
 */
public class TooltipPage extends BasePage {

    private final static Logger LOG = Logger.getLogger(TooltipPage.class);

    @FindBy(xpath = ".//*[@id='age']")
    private WebElement fieldWithTooltip;

    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    public TooltipPage selectElementWithTooltip(){
        fieldWithTooltip.click();
        String toolTipText = fieldWithTooltip.getAttribute("title");
        return null;
    }

    public TooltipPage assertThatTooltipTextIsDisplayed() {
        LOG.info("Assert that Tooltip Message is displayed");
        String tooltipMessage = driver.findElement(By.xpath(".//*[@id='age']")).getAttribute("title");
        Assert.assertTrue(tooltipMessage.contains("We ask for your age only for statistical purposes."));
        return null;
    }
}
