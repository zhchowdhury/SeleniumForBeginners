package reporting.Listeners;

import base.ScriptBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentsReports.ExtentManager;
import reporting.ExtentsReports.ExtentTestManager;

public class Listener extends ScriptBase implements ITestListener {

    private  static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart" +iTestContext.getName());
        iTestContext.setAttribute("WebDriver",this.driver);

    }
    @Override
    public void onFinish(ITestContext iTestContext) {

        System.out.println("I am in onFinish" +iTestContext.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart" +getTestMethodName(iTestResult) + "start");


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am onTestSucces" +getTestMethodName(iTestResult) +"succeed");
        ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("I am onTestFailure " +getTestMethodName(iTestResult)+ "failed");
        Object testClass=iTestResult.getInstance();
        WebDriver webDriver=((ScriptBase) testClass).getDriver();
        String base64Screenshot="data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am onTestSkipped" +getTestMethodName(iTestResult) +"skipped");
        ExtentTestManager.getTest().log(LogStatus.SKIP,"Test skipped");


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        System.out.println("I am onTestFailedButWithinSuccessPercentage" +getTestMethodName(iTestResult));

    }


}
