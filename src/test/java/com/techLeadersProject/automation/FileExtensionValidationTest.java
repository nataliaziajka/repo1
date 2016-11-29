package com.techLeadersProject.automation;

import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Natalia on 2016-11-28.
 */
    @RunWith(Parameterized.class)
    public class FileExtensionValidationTest extends BaseTest {

    private String filename;
    private Boolean expectedResult;

    public FileExtensionValidationTest(String pathToPictures, Boolean expectedResult) {
        super(driver);
        this.filename = pathToPictures;
        this.expectedResult = expectedResult;

    }
//    @Test
//    public void fileExtensionValidationFail() {
//        new DemoQAPage(driver)
//                .clickToRegistrationLink();
//        new RegistrationPage(driver)
//                .uploadFile("C:\\Users\\Natalia\\Documents\\Invoice.pdf")
//                .assertThatFileWasUploadedWithIncorrectExtension();
//    }
    @UseDataProvider("profilePictures")
    public void fileExtensionValidationPass(final String filename, final String expected) {
        assertEquals(expected, filename);

//        new DemoQAPage(driver)
//                .clickToRegistrationLink();
//        new RegistrationPage(driver)
//                .uploadFile("C:\\Users\\Natalia\\IdeaProjects\\" + filename)
//                        .assertThatFileWasUploadedWithIncorrectExtension();
    }

    @Parameterized.Parameters
        public static Collection profilePictures(){
            return Arrays.asList(new Object[][]{
                    {"TechLeadersProject\\src\\test\\resources\\kotek.jpg",true},
                    {"TechLeadersProject\\src\\test\\resources\\kotek.png",true},
                    {"TechLeadersProject\\src\\test\\resources\\kotek.bmp",true},
                    {"TechLeadersProject\\src\\test\\resources\\Invoice.doc",false},
                    {"TechLeadersProject\\src\\test\\resources\\Invoice.pdf",false},
                    {"TechLeadersProject\\src\\test\\resources\\KRS_report.xls",false},


        });
    }
}
