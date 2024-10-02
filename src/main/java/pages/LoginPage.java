package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {
    private final SelenideElement usernameTxt = $(By.name("username"));
    private final SelenideElement passwordTxt = $(By.name("password"));
    private final SelenideElement loginBtn = $(By.className("btn-login"));
    private final SelenideElement adminTxt = $(By.xpath("//a[text()='administrator']"));
    private final SelenideElement logoutBtn = $(By.xpath("//a[text()='Logout']"));

   @Step("Login to system")
    public void login(String username, String password) {
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }
   @Step("Click Login button without entering/**/ model into Username and Password field")
    public void clickLoginBtn() {
        loginBtn.click();
    }
   @Step("Click logout button")
    public void clickLogoutBtn() {
       adminTxt.hover();
       logoutBtn.click();
    }
   @Step("Get alert message")
    public String getAlertMessage() {
       return switchTo().alert().getText();
    }
}
