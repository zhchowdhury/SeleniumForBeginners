package controller;

import base.ScriptBase;
import com.aventstack.extentreports.ExtentTest;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CataloguePage extends ScriptBase {



    public CataloguePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void homePageCataloge(WebDriver driver,String catalogeTab){
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='"+catalogeTab+"']")).click();
        mousOver(driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='"+catalogeTab+"']")),driver);
        arrayList(driver.findElements(By.id("selectProductSort")));

    }


    public void arrayList( List<WebElement> element) {
        List<WebElement> elementlist=element;
        List<String> allTheValue= new ArrayList<>();
        for(int i=0; i<elementlist.size();i++){
            allTheValue.add(elementlist.get(i).getText());
            System.out.println(elementlist.get(i).getText());
        }
    }



    public void mousOver(WebElement element,WebDriver driver){
        Actions actions=new Actions(driver);
        element=element;
        actions.moveToElement(element).perform();

    }




}