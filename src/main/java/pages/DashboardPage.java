package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import models.Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private final SelenideElement header = $(By.id("header"));
    private final SelenideElement globalSettingBtn = $(By.className("mn-setting"));
    private final String optionGlobalSetting = "//a[text()='%s']";
    private final String optionAdministrator = "//a[text()='%s']";
    private final String parentPagePage = "//a[text()='%s']";
    private final String addedPage = "//a[text()='%s']";

    @Step("Is dashboard page displayed")
    public void isDashboardDisplayed() {
        header.should(Condition.visible);
    }

    @Step("Choose an option after click on global setting button")
    public void chooseAnOptionGlobalSetting(String option) {
        globalSettingBtn.click();
        $x(String.format(optionGlobalSetting, option)).click();
    }

    @Step("Choose an option after click on administrator button")
    public void chooseAnOptionAdmin(String option) {
        $x(String.format(optionAdministrator, option)).click();
    }

    @Step("Check newly added page is visible")
    public void checkPageIsAdded(String option) {
        $x(String.format(addedPage, option)).should(Condition.visible);
    }

    @Step("Hover on a specific page")
    public void hoverOnPage(Page page) {
        if (page.getParentPage() != null) {
            hoverOnPage(page.getParentPage());
        }
        $x(String.format(parentPagePage, page.getPageName())).hover();
    }

    @Step("Get message when delete a specific page")
    public String getMessageWhenDeletePage(Page page) {
        hoverOnPage(page);
        clickOnPage(page);
        chooseAnOptionGlobalSetting("Delete");
        return getAlertMessage();
    }

    @Step("Get alert message when delete a page")
    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    @Step("CLick on a specific page")
    public void clickOnPage(Page page) {
        $x(String.format(parentPagePage, page.getPageName())).click();
    }

    @Step("Check page is deleted successfully")
    public void checkPageDeleted(Page page) {
        $x(String.format(parentPagePage, page.getPageName())).shouldNotHave();
    }

    @Step("Check button is disappear")
    public void checkBtnDisappeared(String option) {
        $x(String.format(optionGlobalSetting, option)).shouldNotHave();
    }
}
