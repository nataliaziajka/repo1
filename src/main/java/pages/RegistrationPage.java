package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;


/**
 * Created by Natalia on 2016-11-28.
 */
public class RegistrationPage extends BasePage{

    private final static Logger LOG = Logger.getLogger(DemoQAPage.class);

    @FindBy(css="#phone_9 + div > span")
    private List<WebElement> phoneError;

    @FindBy(css="#profile_pic_10 + div > span")
    private List<WebElement> uploadError;

    @FindBy(css="input[name='first_name']")
    private WebElement firstNameField;

    @FindBy(css="input[name='last_name']")
    private WebElement lastNameField;

    @FindBy(css=("input[value='single']"))
    private WebElement maritalStatusButton;

    @FindBy(css=("input[value='reading']"))
    private WebElement hobbyButton;

    @FindBy(xpath=".//*[@id='yy_date_8']")
    private WebElement year;

    @FindBy(xpath=".//*[@id='mm_date_8']")
    private WebElement month;

    @FindBy(xpath=".//*[@id='dd_date_8']")
    private WebElement day;

    @FindBy(xpath=".//*[@id='dropdown_7']")
    private WebElement country;

    @FindBy(css="input[name='phone_9']")
    private WebElement phoneNumber;

    @FindBy(css="input[name='username']")
    private WebElement userName;

    @FindBy(css="input[name='e_mail']")
    private WebElement e_mail;

    @FindBy(css="input[id='password_2']")
    private WebElement password;

    @FindBy(css="input[id='confirm_password_password_2']")
    private WebElement passwordToConfirm;

    @FindBy(css="input[id='profile_pic_10']")
    private WebElement profilePicture;

    @FindBy(css="input[type='submit']")
    private WebElement submitButton;

    @FindBy(css="p[class='piereg_message']")
    private WebElement confirmationMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.demoqa.com");
    }

    public RegistrationPage assertPhoneNumberError() {
        LOG.info("Assert phone number error displayed");
        Assert.assertTrue(phoneError.size() == 1);
        Assert.assertFalse(phoneError.get(0).getText().equals("* Minimum 10 Digits starting with Country Code"));
        return this;
    }

    public RegistrationPage assertNoPhoneNumberError() {
        LOG.info("Assert no phone number error");
        Assert.assertTrue(phoneError.isEmpty());
        return this;
    }

    public RegistrationPage assertThatConfirmationMessageIsDisplayed() {
        LOG.info("Assert that was entered min characters for phone number");
        Assert.assertTrue(confirmationMessage.getText().contains(" Thank you for your registration"));
        return this;
    }

    public RegistrationPage assertThatFileWasUploadedWithIncorrectExtension() {
        LOG.info("Assert that file was uploaded with incorrect extension");
        Assert.assertTrue(uploadError.get(0).getText().contains(" Invalid File"));
        return this;
    }

    public RegistrationPage enterFirstName(String firstName){
        LOG.info("Enter first name");
        firstNameField.sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName){
        LOG.info("Enter last name");
        lastNameField.sendKeys(lastName);
        return this;
    }
    public RegistrationPage selectMartitalStatus(){
        LOG.info("Select marital status");
        waitForWebElementToBeClickable(maritalStatusButton);
        maritalStatusButton.click();
        return this;
    }
    public RegistrationPage selectHobby(){
        LOG.info("Select hobby");
        waitForWebElementToBeClickable(hobbyButton);
        hobbyButton.click();
        return this;
    }
    public RegistrationPage selectCountry(){
        LOG.info("Select country from drop down list");
        Select countryList = new Select(country);
        countryList.selectByVisibleText("Poland");
        return this;
    }
    public RegistrationPage selectMonth(){
        LOG.info("Select month");
        Select monthList = new Select(month);
        monthList.selectByVisibleText("3");
        return this;
    }

    public RegistrationPage selectDay(){
        LOG.info("Select day");
        Select dayList = new Select(day);
        dayList.selectByVisibleText("21");
        return this;
    }
    public RegistrationPage selectYear(){
        LOG.info("Select year");
        Select yearList = new Select(year);
        yearList.selectByVisibleText("1986");
        return this;
    }

    public RegistrationPage enterPhoneNumber(String phone){
        LOG.info("Select phone number");
        phoneNumber.sendKeys(phone);
        return this;
    }

    public RegistrationPage enterUsername(String username){
        LOG.info("Select username");
        userName.sendKeys(username);
        return this;
    }

    public RegistrationPage enterEmail(String email){
        LOG.info("Select username");
        e_mail.sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String pass){
        LOG.info("Select password");
        password.sendKeys(pass);
        return this;
    }

    public RegistrationPage enterPasswordToConfirm(String pass){
        LOG.info("Select password to confirm");
        passwordToConfirm.sendKeys(pass);
        return this;
    }

    public RegistrationPage uploadFile(String path){
        LOG.info("Upload File:" + path);
        File uploadFile = new File(path);
        profilePicture.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.cssSelector("label[for='profile_pic_10'")).click();
        return this;
    }

    public RegistrationPage clickSubmitButton(){
        LOG.info("Click submit button");
        waitForWebElementToBeClickable(submitButton);
        submitButton.click();
        return this;
    }
}
