import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase014 extends TestBase {
    @Test(description = "Verify that 'Public' pages can be visible and accessed by all users of working repository")
    public void TC014() {
        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Log in specific repository with valid account");
        loginPage.login("administrator", "");

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Go to Global Setting -> Add page");
        dashboardPage.chooseAnOptionGlobalSetting("Add Page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Enter Page Name field");
        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Click OK button");
        logStep = TestReporter.logStepInfo(logMethod, "Step #6: Go to Global Setting -> Add page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Enter Page Name field");
        logStep = TestReporter.logStepInfo(logMethod, "Step #8: Click on Displayed After dropdown list");
        logStep = TestReporter.logStepInfo(logMethod, "Step #9: Select specific page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #10: Click OK button");
        logStep = TestReporter.logStepInfo(logMethod, "Step #11: Check 'Another Test' page is positioned besides the 'Test' page");


    }
}

