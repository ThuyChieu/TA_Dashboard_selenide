import models.Page;
import models.Panel;
import org.testng.annotations.Test;
import pages.AddNewPanelDialog;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewPage;
import reports.TestReporter;

import static listeners.TestListener.logMethod;
import static listeners.TestListener.logStep;

public class TestCase028 {
    @Test(description = "Verify that when 'Add New Panel' form is on focused all other control/form is disabled or locked.")
    public void TC028() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        AddNewPanelDialog addNewPanelDialog = new AddNewPanelDialog();
        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Dashboard login page");

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Log in specific repository with valid account");
        loginPage.login("Administrator", "");

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Click Administer link");
        dashboardPage.chooseAnOptionAdmin("Administer");

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Click Panel link");
        dashboardPage.chooseAnOptionAdmin("Panels");

        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Click Add New link");
        dashboardPage.chooseAnOptionAdmin("Add New");

        logStep = TestReporter.logStepInfo(logMethod, "Step #6: Try to click other controls when " +
                "Add New Panel dialog is opening");
        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Observe the current page");
        addNewPanelDialog.isControlDisabled();
    }
}
