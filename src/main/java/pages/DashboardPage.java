package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import javax.lang.model.element.Element;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement header = $(By.id("header"));
    private final SelenideElement globalSettingBtn = $(By.className("mn-setting"));
    private final String optionGlobalSetting = "//a[text()='%s']";
    private final String optionAdministrator = "//a[text()='%s']";
    private final String addedPage = "//a[text()='%s']";
    private final SelenideElement choosePanelBtn = $(By.id("btnChoosepanel"));
    private final SelenideElement editLink = $(By.xpath("//a[text()='Edit']"));

    @Step("Is dashboard page displayed")
    public boolean isDashboardDisplayed() {
        return header.isDisplayed();
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
    public boolean checkPageIsAdded(String option) {
        return $x(String.format(addedPage, option)).isDisplayed();
    }
}
