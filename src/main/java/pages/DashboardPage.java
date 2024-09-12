package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final SelenideElement header = $(By.id("header"));
    private final SelenideElement globalSettingBtn = $(By.className("mn-setting"));
    private final SelenideElement optionGlobalSetting = $(By.xpath("//a[text()='%s']"));
    private final SelenideElement optionAdministrator = $(By.xpath("//a[text()='%s']"));
    private final SelenideElement parentPageBtn = $(By.xpath("//a[text()='%s']"));
    private final SelenideElement choosePanelBtn = $(By.id("btnChoosepanel"));
    private final SelenideElement editLink = $(By.xpath("//a[text()='Edit']"));

    @Step("Is dashboard page displayed")
    public boolean isDashboardDisplayed() {
       return header.isDisplayed();
    }

    @Step("Choose an option after click on global setting button")
    public void chooseAnOptionGlobalSetting() {
        globalSettingBtn.click();
    }







}
