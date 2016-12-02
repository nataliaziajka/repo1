package com.techLeadersProject.automation;

import org.junit.Test;
import pages.DemoQAPage;

/**
 * Created by Natalia on 2016-11-24.
 */
public class RegistrationTest extends BaseTest{

    @Test
    public void registerAtDemoQaPage(){
            new DemoQAPage(driver)
//                    .openDemoQApage()
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
                        .assertPhoneNumberError()
                        .assertNoPhoneNumberError()
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