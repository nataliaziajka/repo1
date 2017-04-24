package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Natalia on 2017-03-12.
 */
public class AutocompletePage extends BasePage {

    private final static Logger LOG = Logger.getLogger(AutocompletePage.class);

    @FindBy(css = "#menu-item-145>a")
    private WebElement autocompleteSection;

    @FindBy(css = "#tagss")
    private WebElement suggestionsListBox;

    @FindBy(css = "#ui-id-1")
    private List<WebElement> listOfSuggestions;

    @FindBy(css = "#ui-id-95")
    private WebElement selectedItem;

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    public AutocompletePage useDefaultAutocompleteFunction() throws InterruptedException {
        autocompleteSection.click();
        suggestionsListBox.sendKeys("Ja");
        Thread.sleep(1000);
        listOfSuggestions.get(0).click();
        return this;
    }
    public AutocompletePage assertThatElementIsSelectedFromSuggestionsList() throws InterruptedException {
        LOG.info("Assert that element is selected from suggestions list");
        autocompleteSection.click();
        suggestionsListBox.sendKeys("Ja");
        Thread.sleep(1000);
        listOfSuggestions.get(0).click();
        String actualText = suggestionsListBox.getText();
        Assert.assertEquals(actualText, "Java");
        return this;

    }
}