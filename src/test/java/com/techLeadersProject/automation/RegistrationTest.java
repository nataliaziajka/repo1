package com.techLeadersProject.automation;

import org.testng.annotations.Test;
import pages.DemoQAPage;

/**
 * Created by Natalia on 2016-11-24.
 */
public class RegistrationTest extends BaseTest{

    @Test
    public void registerAtDemoQaPage(){

        new DemoQAPage(driver)
                    .clickToRegistrationLink()
                    .enterFirstName("Natalia")
                    .enterLastName("Ziajka")
                    .selectMartitalStatus()
                    .selectHobby()
                    .selectCountry()
                    .selectMonth()
                    .selectDay()
                    .selectYear()
                    .enterPhoneNumber("12345678910")
                    .clickUsernameLabelToValidatePhoneNumber()
                        .assertNoPhoneNumberError()
                    .enterUsername("NZiajka"+generateString())
                    .enterEmail("nataliaziajka"+generateString()+"@gmail.com")
                    .uploadFile("C:\\Users\\Natalia\\Downloads\\zdjecia\\Natalia_Ziajka.jpg")
                        .assertThatFileWasUploadedCorrectly()
                    .enterPassword("DemoQATests16")
                    .enterPasswordToConfirm("DemoQATests16")
                    .clickSubmitButton()
                        .assertThatConfirmationMessageIsDisplayed();
        }
}