import models.Page;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewPage;
import reports.TestReporter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase014 extends TestBase {
    @Test(description = "Verify that 'Public' pages can be visible and accessed by all users of working repository")
    public void TC014() {
        Page page1 = Page.builder().pageName("Page1").publicTick(true).build();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        NewPage newPage = new NewPage();
        List<Page> pages = Collections.singletonList(page1);

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Log in specific repository with valid account");
        loginPage.login("administrator", "");

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Go to Global Setting -> Add page");
        dashboardPage.chooseAnOptionGlobalSetting("Add Page");

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Enter Page Name field");
        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Check Public checkbox");
        logStep = TestReporter.logStepInfo(logMethod, "Step #6: Click OK button");
        newPage.fillInfoNewPageDialog(page1);

        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Click on Log out link");
        dashboardPage.chooseAnOptionAdmin("administrator");
        dashboardPage.chooseAnOptionAdmin("Logout");

        logStep = TestReporter.logStepInfo(logMethod, "Step #8: Log in with another valid account");
        loginPage.login("User1", "123");

        logStep = TestReporter.logStepInfo(logMethod, "Step #9: Check newly added page is visible");
        dashboardPage.checkPageIsAdded("Page1");

        logStep = TestReporter.logStepInfo(logMethod, "Step #10: Delete added page");

        for (int i = pages.size() - 1; i >= 0; i--) {
            Page page = pages.get(i);
            dashboardPage.deleteSpecificPage(page);
        }
    }
}

