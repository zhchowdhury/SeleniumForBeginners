package cartPage;

import base.ScriptBase;
import controller.CartPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class CartPageTest extends ScriptBase {
    CartPage cartPage;

    @Test
    public void verifyBlouseAddCartwithQuantity(){
        log.info("#########----verifyBlouseAddCartwithQuantity test Start----##########");
        cartPage=new CartPage(driver) ;
        cartPage.addCartWithMultipleQuantity("Blouse",5,driver);
        log.info("#########---verifyBlouseAddCartwithQuantity test End----##########");

    }

    @Test
    public void verifySleeveAddCartwithQuantitytwo(){
        log.info("#########----verifySleeveAddCartwithQuantitytwo test Start----##########");
        cartPage=new CartPage(driver) ;
        cartPage.addCartWithMultipleQuantity("Faded Short Sleeve T-shirts",10,driver);
        log.info("#########---verifySleeveAddCartwithQuantitytwo test End----##########");


    }


    @AfterTest
    public void closeBrowsr(){
        driver.close();
        driver.quit();
    }


}
