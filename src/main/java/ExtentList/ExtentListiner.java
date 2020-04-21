package ExtentList;

import base.ScriptBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class ExtentListiner implements ITestListener {

    static Date date =new Date();
    static String reportName="SeleniumForBeginner_"+date.toString().replace(" ","_").replace(":","_")+".html";
    private static ExtentReports extent=ExtentManager.createInstance(System.getProperty("user.dir")+"/ExtentReports/"+reportName);
    private static ThreadLocal<ExtentTest> test =new ThreadLocal<>();
    @Override
    public void onStart(ITestContext contextontext) {
        System.out.println("Selenium for beginner Project test start.");

    }

    @Override
    public void onFinish(ITestContext contextontext) {
        System.out.println("Selenium for beginner Project test ending!");
        extent.flush();


    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" started");
        ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Test passed");
        test.get().pass("Test Passed");



    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Test Failed with exception");
        Object testClass=result.getInstance();
        WebDriver webDriver=((ScriptBase) testClass).getDriver();
        String faieldTestScreenshot="data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        test.get().fail(result.getThrowable()).addScreenCaptureFromBase64String(faieldTestScreenshot);




    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println(result.getMethod().getMethodName()+" Test skipped");
        test.get().fail("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


}
