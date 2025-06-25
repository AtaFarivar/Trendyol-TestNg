package models;

import org.openqa.selenium.By;

public class LoginPageModel {
    public static By girisYapTabButton = By.xpath("//button[.//span[text()='Giriş Yap'] and @aria-pressed='true']");
    public static By uyeOlTabButton = By.xpath("//button[.//span[text()='Üye Ol'] and @aria-pressed='false']");
    public static By emailInput = By.id("login-email");
    public static By passwordInput = By.id("login-password-input");
    public static By loginButton = By.cssSelector("button[type='submit']");
    public static final By errorMessage = By.xpath("//span[@class='message']");

}

