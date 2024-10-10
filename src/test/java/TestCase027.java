import models.Page;
import models.Panel;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase027 {
    @Test(description = "Verify that when 'Choose panels' form is expanded all pre-set panels are populated and sorted correctly")
    public void TC027() {
        Page page1 = Page.builder().pageName("Page1").build();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        NewPage newPage = new NewPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Log in specific repository with valid account");
        loginPage.login("Administrator", "");

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Go to Global Setting -> Add page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Enter page name to Page Name field.");
        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Click OK button");
        dashboardPage.chooseAnOptionGlobalSetting("Add Page");
        newPage.fillInfoNewPageDialog(page1);

        logStep = TestReporter.logStepInfo(logMethod, "Step #6: Go to Global Setting -> Create Panel");
        dashboardPage.chooseAnOptionGlobalSetting("Create Panel");

        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Enter Panel name into Display Name textbox");
        logStep = TestReporter.logStepInfo(logMethod, "Step #8: Select any value in Series* dropdown " +
                "list Click Ok button");
        logStep = TestReporter.logStepInfo(logMethod, "Step #9: Click Ok button in Panel Configuration popup");
        logStep = TestReporter.logStepInfo(logMethod, "Step #10: Click on Choose Panel menu icon next " +
                "to Global Setting icon");
    }
}
