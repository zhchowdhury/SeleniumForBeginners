package ExtentList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {
    private static ExtentReports extent;
    public  static ExtentReports createInstance(String fileName){
        ExtentHtmlReporter report=new ExtentHtmlReporter(fileName);
        report.config().setTheme(Theme.DARK);
        report.config().setDocumentTitle(fileName);
        report.config().setEncoding("uts-8");
        report.config().setReportName(fileName);
        extent=new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Selenium for Beginner ","Zaman");
        extent.setSystemInfo("FutureItVision","IT");
        extent.setSystemInfo("Build No","N/A");

        return extent;
    }

    public  static synchronized ExtentTest getTest(){
        Map extentTestMap=new HashMap();
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
}
