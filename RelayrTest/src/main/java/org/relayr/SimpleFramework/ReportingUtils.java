package org.relayr.SimpleFramework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;

public class ReportingUtils extends  BaseTest{


    /**
     * Creates a new blank report
     * Path is specified in ConfigFile.REPORT_FILE_LOCATION
     * @return
     */
    public ExtentReports  createNewReport(){
        //Create a new Extent report
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + ConfigFile.REPORT_FILE_LOCATION);
        htmlReporter.config().setDocumentTitle("relyar test report"); // Tile of report
        htmlReporter.config().setReportName("relyar test report"); // Name of the report
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    /**
     *Logs Pass/Fail result
     * @param status
     * @param step
     */
    public static void  logResults(boolean status,String step){

        if(status){
            test.log(Status.PASS,step);
            Assert.assertTrue(true);
        }else{
            test.log(Status.FAIL,step);
            Assert.assertFalse(true);
        }
    }



}
