package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SocialMediaPage {


    public SocialMediaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void socialMediaPageVerification(String media, WebDriver driver, String title) {
        driver.findElement(By.xpath("//ul/li[@class='" + media + "']")).click();
        windowhandle(driver, title);


    }

    public void windowhandle(WebDriver driver, String title) {

        String winHandleBefore = driver.getWindowHandle();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String actualTitle = driver.getTitle();
        String expectedTitle = "" + title + "";
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();


        driver.switchTo().window(winHandleBefore);



    }
}
