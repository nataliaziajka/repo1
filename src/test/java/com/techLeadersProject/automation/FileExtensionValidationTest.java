package com.techLeadersProject.automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DemoQAPage;

public class FileExtensionValidationTest extends BaseTest {

    @Test(dataProvider = "profilePicturesPass")
    public void fileExtensionValidationPass(String filename) {
        new DemoQAPage(driver)
                .clickToRegistrationLink()
                .uploadFile("src\\test\\resources\\" + filename)
                .assertThatFileWasUploadedCorrectly();
    }

    @Test(dataProvider = "profilePicturesFail")
    public void fileExtensionValidationFail(String filename) {
        new DemoQAPage(driver)
                .clickToRegistrationLink()
                .uploadFile("src\\test\\resources\\" + filename)
                .assertThatFileWasUploadedWithIncorrectExtension();
    }

    @DataProvider(name = "profilePicturesPass")
    public Object[][] profilePicturesPass() {
        return new Object[][]{
                {"kotek_jpg.jpg"},
                {"kotek_png.png"},
                {"kotek_bmp.bmp"},
                {"kotek_gif.gif"}
        };
    }

    @DataProvider(name = "profilePicturesFail")
    public Object[][] profilePicturesFail() {
        return new Object[][]{
                {"Invoice.doc"},
                {"Invoice.pdf"},
                {"KRS_report.xls"}
        };
    }
}
