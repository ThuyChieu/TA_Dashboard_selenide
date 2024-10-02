package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewPage {
    private final SelenideElement pageName = $(By.xpath("//input[@type='text']"));
    private final SelenideElement parentPage = $(By.id("parent"));
    private final SelenideElement columnNumber = $(By.id("columnnumber"));
    private final SelenideElement displayAfter = $(By.id("afterpage"));
    private final SelenideElement publicTickBox = $(By.id("ispublic"));
    private final SelenideElement OkBtn = $(By.id("OK"));

    @Step("Fill info to create new page")
    public void fillInfoNewPageDialog(Page page) {
        fillPageName(page.getPageName());
        tickPublic(page.isPublicTick());
        clickOKBtn();
    }

    @Step("Fill page name")
    public void fillPageName(String name) {
        if (name != null) {
            pageName.setValue(name);
        }
    }

    @Step("Check or uncheck public")
    public void tickPublic(boolean checkbox) {
        if (Boolean.TRUE.equals(checkbox)) {
            publicTickBox.click();
        }
    }

    @Step("Click on OK button")
    public void clickOKBtn() {
        OkBtn.click();
    }
}
