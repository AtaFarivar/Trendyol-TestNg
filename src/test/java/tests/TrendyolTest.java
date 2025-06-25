package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Pages.HomePage;
import Pages.LoginPage;
import utils.DriverFactory;
import utils.ElementHelper;
import utils.ExtentManager;
import testData.LoginDataProvider;

import java.lang.reflect.Method;

public class TrendyolTest {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ElementHelper helper;
    ExtentReports report;

    @BeforeMethod
    public void setup(Method method) {
        DriverFactory.setDriver();
        driver = DriverFactory.getDriver();
        helper = new ElementHelper(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        report = ExtentManager.getInstance();
    }

    @Test(dataProvider = "loginScenarios", dataProviderClass = LoginDataProvider.class, groups = {"Login Test"})
    public void testLoginScenarios(String email, String password, String expectedError, String scenarioName, int order) {
        ExtentTest test = report.createTest(scenarioName);
        ExtentManager.setExtentTest(test);

        ExtentTest extent = ExtentManager.getExtentTest().get();
        extent.info("🔄 Scenario: " + scenarioName);
        extent.info("📧 Email: " + email);

        homePage.closePopUp();
        homePage.checkItems();
        homePage.clickGirişYapMenu();
        assert loginPage.checkLoginTabActive();

        loginPage.login(email, password);

        if (expectedError != null) {
            assert loginPage.isErrorMessageVisible();
            String actual = loginPage.getErrorMessage();
            extent.info("🚫 Error: " + actual);
            assert actual.equals(expectedError);
            extent.pass("✅ Correct error message");
        } else {
            homePage.checkHesabımMenu();
            extent.pass("✅ Login successful");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        ExtentTest extent = ExtentManager.getExtentTest().get();

        if (result.getStatus() == ITestResult.FAILURE) {
            extent.fail("❌ Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extent.pass("✅ Test passed.");
        } else {
            extent.skip("⚠️ Test skipped.");
        }

        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        ExtentManager.flushReport();
    }
}
