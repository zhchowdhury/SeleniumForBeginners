package controller;

import base.ScriptBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

public class ContactPage extends ScriptBase {


@FindBy(css = "#contact-link > a")
    WebElement contactUsbutton;
@FindBy(id="id_contact")WebElement subjectHeadingSelect;
@FindBy(id = "email")WebElement emailSendKey;
    @FindBy(id = "id_order")WebElement orderreferenceSendKey;
    @FindBy(id = "submitMessage")WebElement submitSendButton;
    @FindBy(id = "message")WebElement messageSendkeys;
    @FindBy(css = "#center_column > p")WebElement SuccessMessage;




    public ContactPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

public void SuccessContcatInfoValidation(String email,String reference,String message,String value ){
    contactUsbutton.click();
    dropdown(subjectHeadingSelect,value);
    emailSendKey.sendKeys(email);
    orderreferenceSendKey.sendKeys(reference);
    messageSendkeys.sendKeys(message);
    submitSendButton.click();
    Assert.assertEquals(SuccessMessage,SuccessMessage);

}


    public void dropdown(WebElement element,String value){
        element=subjectHeadingSelect;
        Select select=new Select(element);
        select.selectByVisibleText(value); }

}
