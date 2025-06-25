package testData;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginScenarios")
    public Object[][] loginScenarios() {
        return new Object[][]{
                {"ata_farivar@yahoo.com", "", "Lütfen şifrenizi giriniz.", "Empty Password", 1},
                {"ata_farivar@yahoo.com", "wrongPass123456", "E-posta adresiniz ve/veya şifreniz hatalı.", "Wrong Password", 2},
                {"ata_farivar@yahoo.com", "6118945@T@", null, "Success Login", 3}
        };
    }
}