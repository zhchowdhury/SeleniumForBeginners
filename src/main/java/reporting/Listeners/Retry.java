package reporting.Listeners;

import base.ScriptBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import reporting.ExtentsReports.ExtentTestManager;

public class Retry implements IRetryAnalyzer {

    private int count=0;
    private static  int maxTry=1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){

            if(count < maxTry){
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                extendReportsFailOperations(iTestResult);
                return true;
            }

        }else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }

        return false;
    }


public void extendReportsFailOperations(ITestResult iTestResult){
        Object testClass=iTestResult.getInstance();
    WebDriver driver=((ScriptBase) testClass).driver;
    String base64Screenshot="data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

}
}