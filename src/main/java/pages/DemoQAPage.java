package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Natalia on 2016-11-16.
 */
public class DemoQAPage {

    @FindBy(xpath="//img[contains(src,'http://demoqa.com/wp-content/uploads/2014/08/Tools-QA-213.png')]")
     private WebElement logo;


 
}
