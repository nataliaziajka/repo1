package com.techLeadersProject.automation;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DemoQAPage;
import pages.RegistrationPage;

/**
 * Created by Natalia on 2016-11-24.
 */
public class RegistrationTest extends BaseTest{

    public RegistrationTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void registerAtDemoQaPage(){

            new DemoQAPage(driver)
                    .clickToRegistrationLink();
            new RegistrationPage(driver)
                    .enterFirstName("Natalia")
                    .enterLastName("Ziajka")
                    .selectMartitalStatus()
                    .selectHobby()
                    .selectCountry()
                    .selectMonth()
                    .selectDay()
                    .selectYear()
                    .enterPhoneNumber("12345678910")
                        .assertPhoneNumberError()
                    .enterUsername("NZiajka")
                    .enterEmail("nataliaziajka@gmail.com")
                    .uploadFile("C:\\Users\\Natalia\\Documents\\Invoice.pdf")
                        .assertThatFileWasUploadedWithIncorrectExtension()
                    .uploadFile("C:\\Users\\Natalia\\Downloads\\zdjecia\\Natalia_Ziajka.jpg")
                    .enterPassword("DemoQATests16")
                    .enterPasswordToConfirm("DemoQATests16")
                    .clickSubmitButton()
                        .assertThatConfirmationMessageIsDisplayed();
        }
}




