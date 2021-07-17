package org.relayr.SimpleFramework;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public static ExtentTest test;
    @BeforeTest
    public void setExtent() {
        ReportingUtils ru = new ReportingUtils();
        extent = ru.createNewReport();
    }

    @BeforeMethod
    public void setup(Method method) {
        test = extent.createTest(method.getName().toString());

    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }







}
