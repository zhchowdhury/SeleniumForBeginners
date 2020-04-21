package login;

import base.ScriptBase;
import controller.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import reporting.ExtentsReports.ExtentTestManager;

public class LoginTest extends ScriptBase {
    LoginPage loginPage;
   @Test (alwaysRun =true,priority = 1,description = "Verify Invalid Login Test")
    public void verifyInvalidLogin() {
       //ExtentTestManager.startTest("verifyInvalidLogin" ,"Invalid Login Scenario with empty username and password.");
        loginPage = new LoginPage(driver);
        loginPage.invalidSignin("futuregroup123@gmail.com","123lkkkckeo");


    }
    @Test (alwaysRun =true,priority = 2,description = "Verify Invalid Login With Invalid Email",dependsOnMethods="verifyInvalidLogin")
    public void verifyInvalidLoginWithInvalidEmail() {
        //ExtentTestManager.startTest("verifyInvalidLoginWithInvalidEmail" ,"Invalid Login Scenario with empty username and password.");
        loginPage = new LoginPage(driver);
        loginPage.invalidSignin("futuregroup123@gmail.com","12345");


    }

    @Test (alwaysRun =true,priority = 3)
    public void verifyvalidLogin() {
        //ExtentTestManager.startTest("verifyvalidLogin" ,"Invalid Login Scenario with empty username and password.");
        loginPage = new LoginPage(driver);
        loginPage.validSignin("futureitgroup@gmail.com","admin123");


    }

    @AfterTest
    public void closeBrowsr(){
       // extent.flush();
      //driver.close();
       driver.quit();
    }

}

