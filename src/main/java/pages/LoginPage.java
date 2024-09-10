package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameTxt = $(By.name("username"));
    private final SelenideElement passwordTxt = $(By.name("password"));
    private final SelenideElement loginBtn = $(By.className("btn-login"));
    private final SelenideElement adminTxt = $(By.xpath("//a[text()='administrator']"));
    private final SelenideElement logoutBtn = $(By.xpath("//a[text()='Logout']"));

    public void login(String username, String password) {
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }
}
