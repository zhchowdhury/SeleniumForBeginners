package controller;

import base.ScriptBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends ScriptBase {
    public static final Logger log=Logger.getLogger(CartPage.class.getName());

    @FindBy(xpath = "//*[@id='header_logo']//img[@class='logo img-responsive']")
    WebElement homePageButton;
    @FindBy(xpath = "//*[@id='quantity_wanted_p']//i[@class='icon-plus']")WebElement quantityPuls;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void addCartWithMultipleQuantity(String product,int quantity,WebDriver driver){
        homePageButton.click();
        log.info("Home Page Button Clicked:"+homePageButton.toString());
        addCartProduct(product,driver);
        log.info("Product add cart done");
        productQuantity(quantity,quantityPuls);
        log.info("Product quantity added");


    }


    public void actionClass(WebElement element,WebDriver driver){
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();

    }

    public void addCartProduct(String product,WebDriver driver){

        driver.findElement(By.xpath("//*[@id='homefeatured']//li//h5/a[@title='"+product+"']")).click();
    }

    public void productQuantity(int quantity,WebElement element){

        for (int i=0;i<quantity;i++){

            element.click();

        }
    }

}
