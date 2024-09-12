import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;
import com.codeborne.selenide.Configuration;
import reports.TestReporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.log4j.xml.DOMConfigurator;


import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static org.testng.CommandLineArgs.THREAD_COUNT;
import static reports.TestReporter.log4j;
import static reports.TestReporter.log4jConfiguration;
import static utils.Constants.*;


public class TestBase {
    public ExtentTest logMethod;
    public ExtentTest logStep = null;
    public static ExtentTest logSuite;
    public ExtentTest logClass;
    public static ExtentReports report = null;
    public String testCaseName;
    public String testNameWithStatus;
    public static ArrayList<String> testCaseList = new ArrayList<String>();

    @Parameters({"browser", "headless"})
    @BeforeTest(alwaysRun = true)
    public void config(String browser, @Optional Boolean headless) {
        Configuration.browser = browser;
        Configuration.headless = headless == null ? Configuration.headless : headless;
    }

    @BeforeSuite
    public synchronized void beforeSuite(){
        log4jConfiguration();
        DOMConfigurator.configure(PROJECT_PATH + "/src/test/resources/suites/log4j.xml");

        log4j.info("BeforeSuite - starts");

        try {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_FILE_PATH);
            htmlReporter.loadXMLConfig(new File(PROJECT_PATH + "/src/test/resources/suites/config.xml"));
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
            logSuite = TestReporter.createTestForExtentReport(report, "Initial Setup");
        } catch (Exception e) {
            System.out.println(report);
            log4j.error("ERROR while initializing Extend report: " + e.getStackTrace());
            TestReporter.logException(logSuite, "ERROR while initializing Extend report", e);
        }

        //Create report folder
        TestReporter.logInfo(logSuite, "Report link: " + REPORT_LOCATION);
        File folder = new File(REPORT_LOCATION);
        folder.mkdirs();

        TestReporter.logInfo(logSuite, "Browser: " + BROWSER);
        TestReporter.logInfo(logSuite, "Thread count: " + THREAD_COUNT);
    }

    @BeforeClass
    public synchronized void beforeClass() {
        log4j.info("BeforeClass - Starts");
        testCaseName = this.getClass().getSimpleName();
    }

    @BeforeMethod
    public synchronized void beforeMethod(Object[] data){
        log4j.info("BeforeMethod - Starts");

        logStep = null;

        open(TADASHBOARD);

        if(data != null && data.length > 0){
            //Get test data for test case
            Hashtable<String, String> dataTest = (Hashtable<String, String>) data[0];
            testNameWithStatus = testCaseName + ": " + dataTest.get("Data");
        }
        else {
            testNameWithStatus = testCaseName;
        }

        //Initiate logClass
        logClass = TestReporter.createTestForExtentReport(report, testNameWithStatus);

        //Initiate logMethod
        logMethod = TestReporter.createNodeForExtentReport(logClass, testCaseName);

        log4j.info("BeforeMethod - Ends");
    }


    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        log4j.info("AfterMethod - Starts");
        testCaseList.add(testNameWithStatus + ": " + logMethod.getStatus());
        clearBrowserCookies();
        clearBrowserLocalStorage();
        report.flush();
        logClass = null;
        log4j.info("AfterMethod - Ends");
    }

    @AfterSuite
    public void afterSuite() {
        TestReporter.getTestCaseExecutionCount(testCaseList);
    }
}
