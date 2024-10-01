package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewPage {
    private final SelenideElement pageName = $(By.xpath("//input[@type='text']"));
    private final SelenideElement parentPage = $(By.id("parent"));
    private final SelenideElement columnNumber = $(By.id("columnnumber"));
    private final SelenideElement displayAfter = $(By.id("afterpage"));
    private final SelenideElement publicTickBox = $(By.id("ispublic"));
    private final SelenideElement OkBtn = $(By.id("OK"));
    private final SelenideElement cancelBtn = $(By.id("Cancel"));
    private final SelenideElement pagePosition = $(By.xpath("//a[text()='%s']/following::a[text()='%s']"));

    @Step("Fill info to create new page")
    public void fillInfoNewPageDialog() {
    }
    @Step("Fill page name")
    public void fillPageName(String name) {
        if (name != null){
            pageName.setValue(name);
        }
    }

}
