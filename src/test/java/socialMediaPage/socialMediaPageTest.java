package socialMediaPage;

import base.ScriptBase;
import controller.SocialMediaPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class socialMediaPageTest extends ScriptBase {
SocialMediaPage socialMediaPage;

    @Test
    public void verifyFacebookPage() {
        socialMediaPage = new SocialMediaPage(driver);
        socialMediaPage.socialMediaPageVerification("facebook",driver,"Selenium Framework Public Group | Faceboo");

    }

    @Test
    public void verifyTwitterPage() {
        socialMediaPage = new SocialMediaPage(driver);
        socialMediaPage.socialMediaPageVerification("twitter",driver,"Selenium Framework (@seleniumfrmwrk) | Twitter");

    }

    @Test
    public void verifyYoutubePage() {
        socialMediaPage = new SocialMediaPage(driver);
        socialMediaPage.socialMediaPageVerification("youtube",driver,"Selenium Framework - YouTube");

    }
    @AfterTest
    public void closeBrowsr(){
        driver.close();
        driver.quit();
    }
}

