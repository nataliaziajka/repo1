package com.techLeadersProject.automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DemoQAPage;
import pages.RegistrationPage;


/**
 * Created by Natalia on 2016-11-28.
 */
public class FileExtensionValidationTest extends DemoQATest {


    @Test
    public void fileExtensionValidationFail() {
        new DemoQAPage(driver)
                .clickToRegistrationLink();
        new RegistrationPage(driver)
                .uploadFile("C:\\Users\\Natalia\\Documents\\Invoice.pdf")
                .assertThatFileWasUploadedWithIncorrectExtension();
    }

    @Test(dataProvider = "extensionFiles")
    public void fileExtensionValidationPass(String filename) {
        new DemoQAPage(driver)
                .clickToRegistrationLink();
        new RegistrationPage(driver)
                .uploadFile("C:\\Users\\Natalia\\IdeaProjects\\" + filename)
                        .assertThatFileWasUploadedWithIncorrectExtension();
    }

    @DataProvider(name = "extensionFiles")
    public Object[][] extensionFiles() {
        return new Object[][]{
                {"TechLeadersProject\\src\\test\\resources\\kotek.jpg"},
                {"TechLeadersProject\\src\\test\\resources\\kotek.png"},
                {"TechLeadersProject\\src\\test\\resources\\kotek.bmp"},
                {"TechLeadersProject\\src\\test\\resources\\Invoice.doc"},
                {"TechLeadersProject\\src\\test\\resources\\Invoice.pdf"},
                {"TechLeadersProject\\src\\test\\resources\\KRS_report.xls"},

        };
    }
}
