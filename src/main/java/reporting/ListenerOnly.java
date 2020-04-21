package reporting;

import base.ScriptBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ListenerOnly extends ScriptBase implements ITestListener {


    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName= result.getName();
        if(result.isSuccess()){
            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/successScreenshots";
                File destFile=new File((String)reportDirectory+"/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                Utils.copyFile(srcFile,destFile);
                Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <image src='"+destFile.getAbsolutePath()+"'height='100' width'100'/> </a>");
            }catch (Exception e){

            }

        }

    }

    @Override
    public void onTestFailure(ITestResult result) {

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName= result.getName();
        if(result.getStatus()==ITestResult.FAILURE){
            File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/failureScreenshots";
                File destFile=new File((String)reportDirectory+"/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                Utils.copyFile(srcFile,destFile);
                Reporter.log("<a href='"+destFile.getAbsolutePath()+"'> <image src='"+destFile.getAbsolutePath()+"'height='100' width'100'/> </a>");
            }catch (Exception e){

            }

        }


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //ExtentReports log operation for skipped tests.

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}
