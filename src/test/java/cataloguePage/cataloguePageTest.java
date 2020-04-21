package cataloguePage;

import base.ScriptBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import controller.CataloguePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import reporting.ExtentsReports.ExtentTestManager;

public class cataloguePageTest extends ScriptBase {

 ExtentTest logger;
 ExtentReports extent;
    CataloguePage cataloguePage;

    @Test (alwaysRun =true)
    public void verifyWomenCatalogeTabDisplay(){
        //logger = extent.createTest("Test Name","Description");
        log.info("#########----verifyWomenCatalogeTabDisplay test Start----##########");
        cataloguePage=new CataloguePage(driver) ;
        cataloguePage.homePageCataloge(driver,"Dresses");
        log.info("#########---verifyWomenCatalogeTabDisplay test End----##########");

    }
    @AfterTest
    public void closeBrowsr(){
        driver.close();
        driver.quit();
    }
}

// 0|1|2|3|4|5
// 1|2|3|4|5|6