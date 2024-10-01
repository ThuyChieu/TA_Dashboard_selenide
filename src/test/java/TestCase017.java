//import org.testng.annotations.Test;
//import pages.DashboardPage;
//import pages.LoginPage;
//import reports.TestReporter;
//
//import static listeners.TestListener.logMethod;
//import static listeners.TestListener.logStep;
//
//public class TestCase017 extends TestBase {
//    @Test(description = "Verify that user can remove any main parent page except 'Overview' page successfully and the order of pages stays persistent as long as there is not children page under it")
//    public void TC017() {
//        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");
//        LoginPage loginPage = new LoginPage();
//        DashboardPage dashboardPage = new DashboardPage();
//
//        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Log in specific repository with valid account");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Add a new parent page");
//        loginPage.login("administrator", "password");
//
//        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Add a children page of newly added page");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Click on parent page");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #6: Click 'Delete' link");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Check confirm message 'Are you sure you want to remove this page?' appears");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #8: Click OK button");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #9: Check warning message 'Can not delete page 'Test' since it has children page(s)' appears");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #10: Click OK button");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #11: Click on  children page");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #12: Click 'Delete' link");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #13: Check confirm message 'Are you sure you want to remove this page?' appears");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #14: Click OK button");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #15: Check children page is deleted");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #16: Click on  parent page");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #17: Click 'Delete' link");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #18: Check confirm message 'Are you sure you want to remove this page?' appears");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #19: Click OK button");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #20: Check parent page is deleted");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #21: Click on 'Overview' page");
//        logStep = TestReporter.logStepInfo(logMethod, "Step #22: Check 'Delete' link disappears");
//    }
//}
