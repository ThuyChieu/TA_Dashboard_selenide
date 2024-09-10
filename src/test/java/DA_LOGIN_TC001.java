import org.testng.annotations.Test;
import pages.LoginPage;
import reports.TestReporter;

public class DA_LOGIN_TC001 extends TestBase{
    @Test(description = "Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
    public void TC001() {
        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        LoginPage loginPage = new LoginPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Enter valid username and password");
        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click on 'Login' button");
        loginPage.login("administrator","");

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that Dashboard Mainpage appears");

    }
}
