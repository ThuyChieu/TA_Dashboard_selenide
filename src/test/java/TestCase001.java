
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;


public class TestCase001 extends TestBase {
    @Test(description = "Verify LoginTc001 that user can login specific repository successfully via Dashboard login page" +
            " with correct credentials")
    public void TC001() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Enter valid username and password");
        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on 'Login' button");
        loginPage.login("", "");

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that Dashboard Mainpage appears");
        dashboardPage.isDashboardDisplayed();
        loginPage.clickLogoutBtn();
    }
}
