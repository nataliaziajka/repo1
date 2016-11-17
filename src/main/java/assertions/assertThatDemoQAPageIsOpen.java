package assertions;

import org.junit.Assert;
import java.util.logging.Logger;

/**
 * Created by Natalia on 2016-11-16.
 */

 abstract class DemoQAPage {

    private char logo;

    public DemoQAPage assertThatDemoQALogoIsDisplayed() {

        Logger.getLogger("Assert DemoQA Page Is Open : ");
        Assert.assertEquals(true, logo.isDisplayed());
        return this;
    }

    public char getLogo() {
        return logo;
    }
}


