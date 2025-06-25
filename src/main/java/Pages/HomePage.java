package Pages;

import models.HomePageModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementHelper;

public class HomePage {

    WebDriver driver;
    ElementHelper helper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    public void closePopUp() {
        helper.clickIfVisible(HomePageModel.closePopUp, 5);
    }

    public void checkItems() {
        Assert.assertTrue(helper.isElementVisible(HomePageModel.trendyolLogo), "'Trendyol Logo' is not visible!");
    }

    public void clickGirişYapMenu() {
        helper.click(HomePageModel.girişyapMenu);
    }

    public void checkHesabımMenu(){
        Assert.assertTrue(helper.isElementVisible(HomePageModel.hesabımMenu));
    }

}
