package homepage;

import base.ScriptBase;
import controller.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HomePageTest extends ScriptBase {
    HomePage homePage;
   @Test
    public void VerifyhomepageContactBarInfo(){
    homePage=new HomePage(driver);
    homePage.homepageContactBarInfo();
    }

    @Test
    public void VerifyHatSearch(){
        homePage=new HomePage(driver);
        homePage.productsSearch("Hat",driver,"7");
    }
    @Test
    public void VerifySleeveSearch(){
        homePage=new HomePage(driver);
        homePage.productsSearch("Sleeve",driver,"4");
    }
    @AfterTest
    public void closeBrowsr(){

        driver.quit();
    }

}

