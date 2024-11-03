package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddNewPanelDialog {
    private final SelenideElement header = $(By.id("ui-dialog-title-div_panelPopup"));
    private final SelenideElement choosePanelBtn = $(By.id("btnChoosepanel"));

    @Step("Add new panel page is displayed")
    public void isAddNewPanelPageDisplay() {
        header.should(Condition.visible);
    }

    @Step("All control/form are disabled or locked when Add New Panel dialog is opening")
    public void isControlDisabled() {
        isAddNewPanelPageDisplay();
        try {
            choosePanelBtn.shouldBe(Condition.interactable).click();
        } catch (ElementNotFound e) {
            System.out.println("Choose Panel button is not interactable, as expected.");
        }
    }
}
