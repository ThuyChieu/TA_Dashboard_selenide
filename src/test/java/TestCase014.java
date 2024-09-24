import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase014 extends TestBase {
    @Test(description = "")
    public void TC014() {
        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        LoginPage loginPage = new LoginPage();
    }
}

