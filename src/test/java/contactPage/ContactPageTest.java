package contactPage;

import base.ScriptBase;
import controller.ContactPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ContactPageTest extends ScriptBase {

ContactPage contactPage;

    @Test
    public void verifyValidContactPageCreate() {
        log.info("#########----verifyValidContactPageCreate test Start----##########");
        contactPage = new ContactPage(driver);
        contactPage.SuccessContcatInfoValidation("Test2@gmail.com","test","This is test","Customer service");
        log.info("#########---verifyValidContactPageCreate test End----##########");    }
    @AfterTest
    public void closeBrowsr(){
        driver.close();
        driver.quit();
    }
}
