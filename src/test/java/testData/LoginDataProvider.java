package testData;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginScenarios")
    public Object[][] loginScenarios() {
        return new Object[][]{
                {" ", "", "Lütfen şifrenizi giriniz.", "Empty Password", 1},
                {"", "wrongPass123456", "E-posta adresiniz ve/veya şifreniz hatalı.", "Wrong Password", 2},
                {"", "", null, "Success Login", 3}
        };
    }
}