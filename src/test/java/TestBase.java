import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.Configuration;
import reports.TestReporter;
import reports.TestReporter.*;
import utils.Constants;


import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static reports.TestReporter.report;


public class TestBase {
    public ExtentTest logMethod;
    public ExtentTest logStep = null;
    public static ExtentTest logSuite;
    public ExtentTest logClass;

    public String testCaseName;
    public String testNameWithStatus;
    public static ArrayList<String> testCaseList = new ArrayList<String>();

    @Parameters({"browser", "headless"})
    @BeforeTest(alwaysRun = true)
    public void config(String browser, @Optional Boolean headless) {
        Configuration.browser = browser;
        Configuration.headless = headless == null ? Configuration.headless : headless;
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        open(Constants.HEROKU_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
//        report.flush();

    }

    @AfterSuite
    public void afterSuite() {
        TestReporter.getTestCaseExecutionCount(testCaseList);
    }
}
