package controller;

import base.ScriptBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ScriptBase{


    @FindBy(partialLinkText = "//*[@id='header']/div[2]/div/div/nav/span//[contains(text(),'Call us now: ')]" )
    WebElement callUsText;
    @FindBy(linkText = "0123-456-789" )
    WebElement phoneNumber;
    @FindBy(linkText ="Contact us" )
    WebElement contactUs;
    @FindBy(xpath = "//*[@id='header']//a[@class='login']")
    WebElement signinButton;
    @FindBy(id = "search_query_top")WebElement search;

    @FindBy(name = "submit_search")WebElement submitSearch;



    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void homepageContactBarInfo(){
        callUsText.isDisplayed();

    }

    public void productsSearch(String productSearch,WebDriver driver,String quantity){

        search.sendKeys(productSearch);
        submitSearch.click();
        driver.findElement(By.xpath("//*[@id='center_column']//span[contains(text(),'"+quantity+" results have been found.')]")).isDisplayed();


    }



}



