import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.TestReporter;

public class testCase001 extends TestBase{
    @Test(description = "Verify LoginTc001 that user can login specific repository successfully via Dashboard login page with correct credentials")
    public void TC001() {
        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Enter valid username and password");
        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on 'Login' button");
        loginPage.login("administrator","");

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that Dashboard Mainpage appears");
        assert dashboardPage.isDashboardDisplayed();
        loginPage.clickLogoutBtn();
    }
}
