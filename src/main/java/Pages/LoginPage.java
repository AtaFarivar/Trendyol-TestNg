package Pages;

import models.LoginPageModel;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class LoginPage {

    WebDriver driver;
    ElementHelper helper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    public boolean checkLoginTabActive() {
        return helper.isElementVisible(LoginPageModel.girisYapTabButton);
    }

    public boolean checkLogoutTabInActive() {
        return helper.isElementVisible(LoginPageModel.uyeOlTabButton);
    }

    public void login(String email, String password) {
        helper.sendKeys(LoginPageModel.emailInput, email);
        helper.sendKeys(LoginPageModel.passwordInput, password);
        helper.click(LoginPageModel.loginButton);
    }

    public String getErrorMessage() {
        return helper.getText(LoginPageModel.errorMessage);
    }

    public boolean isErrorMessageVisible() {
        return helper.isElementVisible(LoginPageModel.errorMessage);
    }

}

