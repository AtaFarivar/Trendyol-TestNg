package models;

import org.openqa.selenium.By;

public class HomePageModel {

    public static By closePopUp = By.xpath("//div[@class='modal-close' and @title='Kapat']");
    public static By trendyolLogo = By.cssSelector("img[alt='Trendyol Türkçe']");
    public static By girişyapMenu = By.xpath("//p[text()='Giriş Yap']");
    public static By hesabımMenu = By.xpath("//p[text()='Hesabım']");

}
