import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase002 extends TestBase {
    @Test(description = "Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
    public void TC002() {
//        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        LoginPage loginPage = new LoginPage();

//        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Enter invalid username and password");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on 'Login' button");
        loginPage.login("administrator", "password");

//        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that Dashboard Error message 'Username or password is invalid' appears");
        assert loginPage.getAlertMessage().contains("Username or password is invalid");
    }
}
