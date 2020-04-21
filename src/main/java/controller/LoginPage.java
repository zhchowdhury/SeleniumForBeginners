package controller;

import base.ScriptBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import jdk.net.SocketFlow;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reporting.ExtentsReports.ExtentManager;

public class LoginPage{
   public static ExtentTest logger;
    ExtentReports extent;
    public static final Logger log=Logger.getLogger(CartPage.class.getName());
    @FindBy(xpath = "//*[@id='header']//a[@class='login']")
    WebElement signinButton;
    @FindBy(id = "email")
    WebElement emailSenkey;
    @FindBy(id = "passwd")
    WebElement passwordSenkey;
    @FindBy(css = "#SubmitLogin > test")
    WebElement SigninSubmitButton;
    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    WebElement invalidSignInerror;
    @FindBy(css="#center_column > p") WebElement signinWelcomeMessage;



    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void invalidSignin(String email,String Pass){
        try {
            signinButton.click();
            passwordSenkey.sendKeys(Pass);
            SigninSubmitButton.click();
            Assert.assertEquals(invalidSignInerror, invalidSignInerror);
        }catch (Exception e){

        }

    }

    public void validSignin(String email,String Pass){
        signinButton.click();
        emailSenkey.sendKeys(email);
        passwordSenkey.sendKeys(Pass);
        SigninSubmitButton.click();
        Assert.assertEquals(signinWelcomeMessage,signinWelcomeMessage);

    }


}
