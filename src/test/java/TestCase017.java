import models.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase017 extends TestBase {
    @Test(description = "Verify that user can remove any main parent page except 'Overview' page successfully and " +
            "the order of pages stays persistent as long as there is not children page under it")
    public void TC017() {
        Page pageTest = Page.builder().pageName("Test").build();
        Page pageTestChild = Page.builder().pageName("TestChild").parentPage(pageTest).build();
        Page pageOverview = Page.builder().pageName("Overview").build();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        NewPage newPage = new NewPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Log in specific repository with valid account");
        loginPage.login("Administrator", "");

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Add a new parent page");
        dashboardPage.chooseAnOptionGlobalSetting("Add Page");
        newPage.fillInfoNewPageDialog(pageTest);

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Add a children page of newly added page");
        dashboardPage.chooseAnOptionGlobalSetting("Add Page");
        newPage.fillInfoNewPageDialog(pageTestChild);

        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Click on parent page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #6: Click 'Delete' link");

        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Check confirm message 'Are you sure you " +
                "want to remove this page?' appears");
        logStep = TestReporter.logStepInfo(logMethod, "Step #8: Click OK button");
        Assert.assertEquals(dashboardPage.getMessageWhenDeletePage(pageTest), "Are you sure you want to " +
                "remove this page?");

        logStep = TestReporter.logStepInfo(logMethod, "Step #9: Check warning message 'Can not delete " +
                "page 'Test' since it has children page(s)' appears");
        logStep = TestReporter.logStepInfo(logMethod, "Step #10: Click OK button");
        Assert.assertEquals(dashboardPage.getAlertMessage(), "Cannot delete page 'Test' since it has " +
                "child page(s)");

        logStep = TestReporter.logStepInfo(logMethod, "Step #11: Click on  children page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #12: Click 'Delete' link");
        logStep = TestReporter.logStepInfo(logMethod, "Step #13: Check confirm message 'Are you sure you " +
                "want to remove this page?' appears");
        logStep = TestReporter.logStepInfo(logMethod, "Step #14: Click OK button");
        Assert.assertEquals(dashboardPage.getMessageWhenDeletePage(pageTestChild), "Are you sure you want " +
                "to remove this page?");

        logStep = TestReporter.logStepInfo(logMethod, "Step #15: Check children page is deleted");
        dashboardPage.checkPageDeleted(pageTestChild);

        logStep = TestReporter.logStepInfo(logMethod, "Step #16: Click on  parent page");
        logStep = TestReporter.logStepInfo(logMethod, "Step #17: Click 'Delete' link");
        logStep = TestReporter.logStepInfo(logMethod, "Step #18: Check confirm message 'Are you sure you " +
                "want to remove this page?' appears");
        logStep = TestReporter.logStepInfo(logMethod, "Step #19: Click OK button");
        Assert.assertEquals(dashboardPage.getMessageWhenDeletePage(pageTest), "Are you sure you want to " +
                "remove this page?");

        logStep = TestReporter.logStepInfo(logMethod, "Step #20: Check parent page is deleted");
        dashboardPage.checkPageDeleted(pageTest);

        logStep = TestReporter.logStepInfo(logMethod, "Step #21: Click on 'Overview' page");
        dashboardPage.clickOnPage(pageOverview);

        logStep = TestReporter.logStepInfo(logMethod, "Step #22: Check 'Delete' link disappears");
        dashboardPage.checkBtnDisappeared("Delete");
    }
}
