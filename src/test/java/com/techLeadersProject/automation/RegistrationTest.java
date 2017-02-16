package com.techLeadersProject.automation;

import org.testng.annotations.Test;
import pages.DemoQAPage;

/**
 * Created by Natalia on 2016-11-24.
 */
public class RegistrationTest extends BaseTest {

    @Test
    public void registerAtDemoQaPage() {
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
                .enterUsername("NZiajka" + generateString())
                .enterEmail("nataliaziajka" + generateString() + "@gmail.com")
                .uploadFile("src\\test\\resources\\kotek_jpg.jpg")
                .assertThatFileWasUploadedCorrectly()
                .enterPassword("DemoQATests16")
                .enterPasswordToConfirm("DemoQATests16")
                .clickSubmitButton()
                .assertThatConfirmationMessageIsDisplayed();
    }
}